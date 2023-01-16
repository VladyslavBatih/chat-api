package com.my.chatapi.controller;

import com.my.chatapi.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Controller of the Chat Application to handle requests of web socket clients
 *
 * @author Vladyslav Batih
 * @version 1.0
 */
@Controller
public class ChatController {

    /**
     * Method to send to web socket clients message is typed by web socket clients
     *
     * @param message Message typed in Chat Application
     * @return Message sent to web socket clients
     * @see com.my.chatapi.model.Message
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload final Message message) {
        return message;
    }

    /**
     * Method to send to web socket clients message of joining new web socket client
     *
     * @param message Prepared Message
     * @return Message sent to web socket clients
     * @see com.my.chatapi.model.Message
     */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message newUser(@Payload final Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}