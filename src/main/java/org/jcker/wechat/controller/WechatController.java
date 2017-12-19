package org.jcker.wechat.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.jcker.wechat.turingbot.Message;
import org.jcker.wechat.constant.ConstantWeChat;
import org.jcker.wechat.entity.message.resp.Article;
import org.jcker.wechat.entity.message.resp.NewsMessage;
import org.jcker.wechat.entity.message.resp.TextMessage;
import org.jcker.wechat.service.SignService;
import org.jcker.wechat.service.WebMessageService;
import org.jcker.wechat.service.WechatMessageService;
import org.jcker.wechat.util.HttpHelper;
import org.jcker.wechat.util.MessageUtil;
import org.jcker.wechat.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WechatController {
    private static final long serialVersionUID = 1L;
    @Autowired
    static WebMessageService webMessageService;

    /**
     * 微信授权，授权完毕，即可注释掉。
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = {"/wechat"}, method = {RequestMethod.GET})
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 随机字符串
        String echostr = request.getParameter("echostr");
        System.out.println("--------------------------------------------------------");
        System.out.println("echostr = " + echostr);
        System.out.println("--------------------------------------------------------");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignService.checkSignature(request)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @RequestMapping(value = {"/wechat"}, method = {RequestMethod.POST})
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = processWechatRequest(request);

        // 响应消息
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 核心处理方法
     *
     * @param request 请求
     * @return 返回消息
     */
    private String processWechatRequest(HttpServletRequest request) {
        try {
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            String msgType = requestMap.get("MsgType");

            switch (msgType) {
                case ConstantWeChat.REQ_MESSAGE_TYPE_TEXT:
                    return buildResponse(requestMap, requestMap.get("Content"));
                case ConstantWeChat.REQ_MESSAGE_TYPE_VOICE:
                    return buildResponse(requestMap, StringUtils.isEmpty(requestMap.get("Recognition")) ? requestMap.get("Recognition") : "你说的是普通话吗?我没听懂/::~");
                case ConstantWeChat.REQ_MESSAGE_TYPE_IMAGE:
                    System.out.println("Image Message");
                    return "success";
                case ConstantWeChat.REQ_MESSAGE_TYPE_LINK:
                    System.out.println("Link Message");
                    return "success";
                case ConstantWeChat.REQ_MESSAGE_TYPE_LOCATION:
                    System.out.println("Location Message");
                    return "success";
                case ConstantWeChat.REQ_MESSAGE_TYPE_EVENT:
                    String eventType = requestMap.get("Event");
                    switch (eventType) {
                        case ConstantWeChat.EVENT_TYPE_SUBSCRIBE:
                            return buildResponse(requestMap, "Thank you for subscribe, now you can ask me anything at anytime.");
                        case ConstantWeChat.EVENT_TYPE_CLICK:
                            System.out.println("Click Event");
                            return "success";
                        case ConstantWeChat.EVENT_TYPE_SCAN:
                            System.out.println("Scan Event");
                            return "success";
                        case ConstantWeChat.EVENT_TYPE_UNSUBSCRIBE:
                            System.out.println("Unsubscribe Event");
                            return "success";
                    }
            }
        } catch (Exception e) {
            return "success";
        }
        return "success";
    }

    private static NewsMessage buildLinkMessage(Message message, Map<String, String> requestMap) {
        NewsMessage newsMessage = (NewsMessage) WechatMessageService.bulidBaseMessage(requestMap, ConstantWeChat.RESP_MESSAGE_TYPE_NEWS);
        List<Article> articleList = new ArrayList<Article>();
        Article article = new Article();
        article.setTitle("快看我发现了什么");
        article.setDescription(message.getText());
        article.setPicUrl("http://orag51y4c.bkt.clouddn.com/bequiet20170528230728.jpg");
        article.setUrl(message.getUrl());

        articleList.add(article);
        newsMessage.setArticleCount(articleList.size());
        newsMessage.setArticles(articleList);
        return newsMessage;
    }

    private static String getTuringAnswer(String content) {
        String answer = "";
        String userId = content.substring(content.indexOf("userid="), content.indexOf("&info"));
//        User user = weChatUserService.getUserByUserId(userId);
        String username = "";
        // this user did not subscribe, so push recommend message.
        username = "Anonymous";
        answer = "Please Follow Me For More Special Service.";
        answer = HttpHelper.sendPost("http://www.tuling123.com/openapi/api?key=7891e8bbdf5b4315a35acf9a0bedfafa", content);


        return answer;
    }

    private String buildResponse(Map<String, String> requestMap, String content) throws Exception {
        String answer = getTuringAnswer("userid=" + requestMap.get("FromUserName") + "&info=" + content);


        Message message = JSON.parseObject(answer, Message.class);
        if (StringUtil.isNotEmpty(message.getUrl())) {
            //link message
            NewsMessage newsMessage = buildLinkMessage(message, requestMap);
            return WechatMessageService.bulidSendMessage(newsMessage, ConstantWeChat.RESP_MESSAGE_TYPE_NEWS);
        } else {
            //send message to community
            String webMessage = "关注者：" + content + "|-|公众号：" + message.getText();
            System.out.println("webMessage = " + webMessage);

            //text message
            TextMessage textMessage = (TextMessage) WechatMessageService.bulidBaseMessage(requestMap, ConstantWeChat.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setContent(message.getText());
            return WechatMessageService.bulidSendMessage(textMessage, ConstantWeChat.RESP_MESSAGE_TYPE_TEXT);
        }
    }
}
