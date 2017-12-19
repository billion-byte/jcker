package org.jcker.smartqq.dao;

import org.jcker.smartqq.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Long> {
    List<Message> findMessagesByUserId(Long paramLong);
}
