package com.medium.pubsub.ship;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ChatInterface implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Scanner scanner;

    @Value("${ship.name}")
    private String shipName;
    @Value("${broker.exchange.direct.station.name}")
    private String directExchange;
    @Value("${broker.exchange.direct.station.routing-key}")
    private String directExchangeRoutingKey;

    public ChatInterface(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) {
        System.out.println("Booting up: " + shipName.toUpperCase());
        System.out.println("Please enter the message..");
        while (true) {
            String msg = scanner.nextLine();
            rabbitTemplate.convertAndSend(directExchange, directExchangeRoutingKey, shipName + ": " + msg);
        }
    }
}
