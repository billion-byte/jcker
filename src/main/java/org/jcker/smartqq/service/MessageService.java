package org.jcker.smartqq.service;

import org.jcker.smartqq.domain.Message;

import java.util.List;

public interface MessageService
{
  Message findMessageByTime(long paramLong);

  void saveOrUpdateMessage(Message paramMessage);

  List<Message> findMessageByUserId(Long paramLong);
}
