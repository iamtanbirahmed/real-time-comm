package com.medium.pubsub.station;

import com.medium.pubsub.station.component.MessageHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ChatInterface implements CommandLineRunner {
    private Scanner scanner;
    private final MessageHandler messageHandler;

    public ChatInterface(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) {
        System.out.println("Send message...");
        while (true) {
            String msg = scanner.nextLine();
            if(msg.contains(":")){
                messageHandler.sendMessage(msg);
            }else{
                System.out.println("Message format not correct!!");
            }

        }
    }
}
