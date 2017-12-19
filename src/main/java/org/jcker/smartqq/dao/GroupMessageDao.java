package org.jcker.smartqq.dao;

import org.jcker.smartqq.domain.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMessageDao extends JpaRepository<GroupMessage, Long> {

    List<GroupMessage> findAllByUserId(long userId);

    List<GroupMessage> findByGroupId(long groupId);

    List<GroupMessage> findAllByGroupIdOrderByTime(long groupId);
}
