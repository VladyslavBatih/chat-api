package com.my.chatapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * Model of message that is sent to users of the Chat Application
 *
 * @author Vladyslav Batih
 * @version 1.0
 */
@Setter
@Getter
@Builder
public class Message {

    private MessageType type;
    private String content;
    private String sender;
}