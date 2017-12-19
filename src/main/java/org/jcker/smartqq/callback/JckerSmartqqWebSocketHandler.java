package org.jcker.smartqq.callback;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service()
public class JckerSmartqqWebSocketHandler extends TextWebSocketHandler {
    private static Logger log = Logger.getLogger(JckerSmartqqWebSocketHandler.class);
    private static final ArrayList<WebSocketSession> users = new ArrayList();
    private static final Map<String, String> map = new HashMap();

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("链接成功......");
        users.add(session);
    }

    protected void handleTextMessage(WebSocketSession session1, TextMessage message) throws Exception {
        for (WebSocketSession session : users)
            session.sendMessage(message);
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.debug("链接关闭......" + closeStatus.toString());
        users.remove(session);
    }
}
