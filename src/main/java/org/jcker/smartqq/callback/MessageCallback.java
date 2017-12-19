package org.jcker.smartqq.callback;

import org.jcker.smartqq.domain.DiscussMessage;
import org.jcker.smartqq.domain.GroupMessage;
import org.jcker.smartqq.domain.Message;

public interface MessageCallback
{
    void onMessage(Message paramMessage);

    void onGroupMessage(GroupMessage paramGroupMessage);

    void onDiscussMessage(DiscussMessage paramDiscussMessage);
}
