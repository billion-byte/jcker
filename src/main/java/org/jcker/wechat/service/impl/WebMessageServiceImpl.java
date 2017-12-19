package org.jcker.wechat.service.impl;

import org.jcker.wechat.entity.message.resp.TextMessage;
import org.jcker.wechat.entity.web.Message;
import org.jcker.wechat.service.WebMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan Turing on 2017/7/3.
 */
@Service("webMessageService")
public class WebMessageServiceImpl implements WebMessageService {
    public List<Message> listAllMessage() {
        return null;
    }

    public Message getWechatMessage(TextMessage textMessage) {
        Message message = new Message();
        message.setId(textMessage.getFromUserName());
        message.setText(textMessage.getContent());
        return message;
    }
}
