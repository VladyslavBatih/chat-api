package com.my.chatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the Chat Application.
 * Application launch point
 *
 * @author Vladyslav Batih
 * @version 1.0
 */
@SpringBootApplication
public class ChatApplication {

    /**
     * Main method to launch the Chat Application
     *
     * @param args Arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }
}