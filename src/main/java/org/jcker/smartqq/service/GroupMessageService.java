package org.jcker.smartqq.service;

import org.jcker.smartqq.domain.GroupMessage;

import java.util.List;

public interface GroupMessageService {
    List<GroupMessage> getGroupMessage();

    GroupMessage getGroupMessage(GroupMessage paramGroupMessage);

    void saveGroupMessage(GroupMessage paramGroupMessage);

    List<GroupMessage> getLatestGroupMessage();

    List<GroupMessage> findAllByUserId(long userId);

    List<GroupMessage> findAllByGroupId(long groupId);

    List<GroupMessage> findByGroupId(long groupId);

}
