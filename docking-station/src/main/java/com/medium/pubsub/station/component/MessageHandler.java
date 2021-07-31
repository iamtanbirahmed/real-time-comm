package com.medium.pubsub.station.component;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {
    private final RabbitTemplate rabbitTemplate;

    public MessageHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void receiveMessage(String message) {
        System.out.println("> " + message);
    }

    public void sendMessage(String cmd) {
        String to = cmd.split(":")[0];
        String msg = cmd.split(":")[1];
        switch(to){
            case "@rocinante":
                rabbitTemplate.convertAndSend("rocinante-direct-exchange", "__rocinante", "Station-O21: "+msg);
                break;
            case "@razorback":
                rabbitTemplate.convertAndSend("razorback-direct-exchange", "__razorback", "Station-O21: "+msg);
                break;
            case "@nauvoo":
                rabbitTemplate.convertAndSend("nauvoo-direct-exchange", "__nauvoo", "Station-O21: "+msg);
                break;
            case "@all":
                rabbitTemplate.convertAndSend("tyco-fanout-exchange", "","Station: "+msg);
                break;
            default:
                System.out.println("Message format not correct!!");
        }
    }
}
