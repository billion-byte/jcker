package org.jcker.smartqq.service.impl;

import org.jcker.smartqq.dao.GroupMessageDao;
import org.jcker.smartqq.domain.GroupMessage;
import org.jcker.smartqq.service.GroupMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("groupMessageService")
@Transactional
public class GroupMessageServiceImpl
        implements GroupMessageService {

    @Autowired
    GroupMessageDao groupMessageDao;


    public List<GroupMessage> getGroupMessage() {
        return this.groupMessageDao.findAll();
    }

    public GroupMessage getGroupMessage(GroupMessage groupMessage) {
        return this.groupMessageDao.getOne(groupMessage.getTime());
    }

    public void saveGroupMessage(GroupMessage groupMessage) {
        this.groupMessageDao.saveAndFlush(groupMessage);
    }

    public List<GroupMessage> getLatestGroupMessage() {
        return this.groupMessageDao.findAll();
    }

    @Override
    public List<GroupMessage> findAllByUserId(long userId) {
        return this.groupMessageDao.findAllByUserId(userId);
    }

    @Override
    public List<GroupMessage> findAllByGroupId(long groupId) {
        return groupMessageDao.findAllByGroupIdOrderByTime(groupId);
    }

    @Override
    public List<GroupMessage> findByGroupId(long groupId) {
        return groupMessageDao.findByGroupId(groupId);
    }

}
