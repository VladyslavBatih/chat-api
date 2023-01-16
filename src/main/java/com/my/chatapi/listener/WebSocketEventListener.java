package com.my.chatapi.listener;

import com.my.chatapi.model.Message;
import com.my.chatapi.model.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Event listener of page load and disconnection of web socket clients
 *
 * @author Vladyslav Batih
 * @version 1.0
 */
@Slf4j
@Component
public class WebSocketEventListener {

    @Autowired
    private SimpMessageSendingOperations sendingOperations;

    /**
     * Method to handle web socket client connection to page
     *
     * @param event Session connected event
     */
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        log.info("New user connected to the Chat");
    }

    /**
     * Method to handle web socket client disconnection from page
     *
     * @param event Session connected event
     */
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        log.info("User disconnected from the Chat");
        Message message = Message.builder().type(MessageType.LEAVE).build();
        sendingOperations.convertAndSend("/topic/public", message);
    }
}