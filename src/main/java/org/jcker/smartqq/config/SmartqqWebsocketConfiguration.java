package org.jcker.smartqq.config;

import org.jcker.smartqq.callback.JckerSmartqqWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-12-13 at 11:44 AM
 *
 * @version 1.0
 */
@Configuration
@EnableWebSocket
public class SmartqqWebsocketConfiguration implements WebSocketConfigurer {
    @Autowired
    JckerSmartqqWebSocketHandler jckerSmartqqWebSocketHandler;

    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(jckerSmartqqWebSocketHandler, "/websocket/qqmessage");
    }
}