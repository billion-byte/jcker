package org.jcker.smartqq.service.impl;

import org.jcker.smartqq.dao.MessageDao;
import org.jcker.smartqq.domain.Message;
import org.jcker.smartqq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("messageService")
@Transactional
public class MessageServiceImpl
  implements MessageService
{

  @Autowired
  MessageDao messageDao;

  public Message findMessageByTime(long time)
  {
    return (Message)this.messageDao.findOne(Long.valueOf(time));
  }

  public void saveOrUpdateMessage(Message message)
  {
    this.messageDao.saveAndFlush(message);
  }

  public List<Message> findMessageByUserId(Long userId)
  {
    return this.messageDao.findMessagesByUserId(userId);
  }
}
