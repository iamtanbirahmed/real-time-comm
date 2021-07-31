package com.medium.pubsub.ship.component;


import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.Long.*;

@Component
@EnableScheduling
public class UpdateScheduler {

    @Value("${ship.name}")
    private String shipName;
    @Value("${broker.exchange.direct.station.name}")
    private String directExchange;

    @Value("${broker.exchange.direct.station.routing-key}")
    private String directExchangeRoutingKey;

    private Long shipUpdateFrequency;

    @Value("${ship.update-freq}")
    private void setShipUpdateFrequency(String frequency) {
        this.shipUpdateFrequency = Long.parseLong(frequency);
    }

    private final RabbitTemplate rabbitTemplate;

    public UpdateScheduler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @SneakyThrows
    @Scheduled(fixedDelay = 1)
    public void sendUpdates() {
        String updateMessage = shipName + ": Update at " + new Date() + " " + ParameterFactory.getParameter();
        rabbitTemplate.convertAndSend(directExchange, directExchangeRoutingKey, updateMessage);
        Thread.sleep(shipUpdateFrequency);
    }

}
