package org.jcker.smartqq.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jcker.smartqq.client.SmartQQClient;
import org.jcker.smartqq.dao.GroupMessageDao;
import org.jcker.smartqq.domain.DiscussMessage;
import org.jcker.smartqq.domain.GroupMessage;
import org.jcker.smartqq.domain.GroupUser;
import org.jcker.smartqq.domain.Message;
import org.jcker.smartqq.service.GroupInfoService;
import org.jcker.smartqq.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.List;

@Service("messageCallback")
public class MessageCallbackImpl
        implements MessageCallback {
    public static final Logger log = Logger.getLogger(MessageCallbackImpl.class);

    @Autowired
    GroupMessageDao groupMessageDao;

    @Autowired
    JckerSmartqqWebSocketHandler jckerSmartqqWebSocketHandler;

    @Autowired
    GroupService groupService;

    @Autowired
    GroupInfoService groupInfoService;

    public void onMessage(Message message) {
    }

    public void onGroupMessage(GroupMessage message) {
        try {
            String fmtStr = "";
            if (StringUtils.isEmpty(fmtStr = message.getContent().replaceAll("\\[\"face\",\\d++\\]", ""))) {
                return;
            }
            List<GroupUser> groupUserList = SmartQQClient.groupInfoMap.get(message.getGroupId()).getUsers();
            String nickname = null;
            for (GroupUser groupUser : groupUserList) {
                if (groupUser.getUin() == message.getUserId()) {
                    nickname = groupUser.getNick();
                    break;
                }
            }
            message.setNickname(nickname);
            message.setContent(fmtStr);
            long id = message.getGroupId();
            message.setGroupId(SmartQQClient.groupInfoMap.get(message.getGroupId()).getCreatetime());
            this.groupMessageDao.save(message);
            message.setGroupId(id);

            ObjectMapper mapper = new ObjectMapper();
            String messageString = mapper.writeValueAsString(message);
            this.jckerSmartqqWebSocketHandler.handleMessage(null, new TextMessage(messageString));
            System.out.println("message = " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDiscussMessage(DiscussMessage message) {
    }
}
