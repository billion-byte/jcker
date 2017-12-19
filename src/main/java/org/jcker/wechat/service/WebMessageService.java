package org.jcker.wechat.service;

import org.jcker.wechat.entity.message.resp.TextMessage;
import org.jcker.wechat.entity.web.Message;

import java.util.List;

/**
 * Created by Alan Turing on 2017/7/3.
 */
public interface WebMessageService {
    List<Message> listAllMessage();

    Message getWechatMessage(TextMessage textMessage);
}
