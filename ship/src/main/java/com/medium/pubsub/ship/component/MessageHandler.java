package com.medium.pubsub.ship.component;

import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    public void handleMessage(String message) {
        System.out.println("> " + message);
    }
}
