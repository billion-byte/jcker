package org.jcker.smartqq.controller;

import org.apache.log4j.Logger;
import org.jcker.smartqq.callback.JckerSmartqqWebSocketHandler;
import org.jcker.smartqq.callback.MessageCallback;
import org.jcker.smartqq.client.SmartQQClient;
import org.jcker.smartqq.domain.Group;
import org.jcker.smartqq.domain.GroupInfo;
import org.jcker.smartqq.domain.GroupMessage;
import org.jcker.smartqq.service.GroupInfoService;
import org.jcker.smartqq.service.GroupMessageService;
import org.jcker.smartqq.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-12-13 at 9:07 AM
 *
 * @version 1.0
 */
@Controller
@RequestMapping("/smartqq")
public class SmartqqController {
    private static Logger log = Logger.getLogger(SmartqqController.class);
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupMessageService groupMessageService;
    @Autowired
    private MessageCallback messageCallback;
    @Autowired
    GroupInfoService groupInfoService;

    public static SmartQQClient client = null;

    private static boolean loginFlag = false;

    @RequestMapping("/personal/{userId}")
    public String goToPersonal(GroupMessage groupMessage, Model model) {

        model.addAttribute("id", groupMessage.getUserId());
        return "personal";
    }

    @ResponseBody
    @RequestMapping("/personalmessage/{userId}")
    public List<GroupMessage> queryPersonalMessages(GroupMessage groupMessage) {

        return this.groupMessageService.findAllByUserId(groupMessage.getUserId());
    }


    @ResponseBody
    @RequestMapping("/groupmessage/{groupId}")
    public List<GroupMessage> queryGroupMessages(GroupMessage groupMessage) {
        System.out.println("groupMessage = " + groupMessage);
        return this.groupMessageService.findAllByGroupId(groupMessage.getGroupId());
    }

    /**
     * 初始化QQ页面，这里的数据操作需要做修改，毕竟每次查询所有的记录再取前10条是一个非常不合情理的做法。
     *
     * @param group 装载 id
     * @return 返回最新消息
     */
    @ResponseBody
    @RequestMapping("/initIndexPage/{id}")
    public List<GroupMessage> initIndexPage(Group group) {
        List list;
        if (group.getId() == 0) {
            list = this.groupMessageService.getLatestGroupMessage();
            if (list.size() > 10) {
                list = list.subList(list.size() - 10, list.size());
            }
        } else {
            list = this.groupMessageService.findAllByGroupId(group.getId());
        }
        return list;
    }

    /**
     * start qq
     *
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping({"/login"})
    public String login() throws IOException {
        if (!loginFlag) {
            client = new SmartQQClient(this.messageCallback);
            loginFlag = true;

            List<Group> groupList = client.getGroupList();
            for (Group group : groupList) {
                GroupInfo groupInfo = client.getGroupInfo(group.getCode());
                SmartQQClient.groupInfoMap.put(group.getId(), groupInfo);
                group.setId(groupInfo.getCreatetime());
                groupService.saveGroup(group);
            }
            return "true";
        } else {
            return "false" + client.getAccountInfo().getUin();
        }
    }

    @ResponseBody
    @RequestMapping({"/logout"})
    public boolean logout() {
        try {
            client.close();
            loginFlag = false;
            log.info("smart qq closed.......................");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping({"/reload"})
    public String reload() {
        try {
            for (Map.Entry info : SmartQQClient.groupInfoMap.entrySet()
                    ) {
                System.out.println(info.getKey().toString());
            }
            if (client != null) {
                List<Group> list = client.getGroupList();
                for (Group group : list) {
                    GroupInfo groupInfo = client.getGroupInfo(group.getCode());
                    SmartQQClient.groupInfoMap.put(group.getId(), groupInfo);
                    if (groupInfo.getName().equals("User")) {
                        System.out.println(group);
                        System.out.println("Createtime = " + groupInfo.getCreatetime());
                        System.out.println("Gid = " + groupInfo.getGid());
                    }
                    Thread.sleep(2000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/";
    }

    @ResponseBody
    @RequestMapping("/scan")
    public boolean qrcode(HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/assets/img/");
        File file = new File(SmartQQClient.filePath);
        if (file.exists()) {
            return file.renameTo(new File(path + file.getName()));
        }
        return false;
    }

    /**
     * 获取群信息
     *
     * @param group 接收前台传来的群id
     * @return
     */
    @ResponseBody
    @RequestMapping("group/{id}")
    public GroupInfo goToGroup(Group group) {
        GroupInfo groupInfo = null;
        try {
            groupInfo = SmartQQClient.groupInfoMap.get(group.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupInfo;
    }

    @ResponseBody
    @RequestMapping("/getgrouplist")
    public List<Group> findAll() {
        if (SmartqqController.client == null) {
            return null;
        }
        return SmartqqController.client.getGroupList();
    }

    @RequestMapping("/updategrouplist")
    public String updateGroupList() {
        SmartQQClient client = SmartqqController.client;
        if (client != null) {
            this.groupService.saveOrUpdateGroup(SmartqqController.client.getGroupList());
        }
        return "/";
    }
}
