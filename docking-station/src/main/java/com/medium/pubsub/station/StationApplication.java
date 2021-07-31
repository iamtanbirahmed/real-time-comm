package com.medium.pubsub.station;

import com.medium.pubsub.station.component.MessageHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StationApplication {
    public static void main(String[] args) {
        SpringApplication.run(StationApplication.class, args);
    }
}
