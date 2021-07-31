package com.medium.pubsub.ship.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerConfiguration {

    static String shipExchangeQueue;
    static String shipRoutingKey;

    @Value("${broker.exchange.direct.ship.routing-key}")
    private void setShipRoutingKey(String routingKey) {
        BrokerConfiguration.shipRoutingKey = routingKey;
    }

    @Value("${broker.exchange.queue.name}")
    private void setExchangeQueue(String exchangeQueue) {
        BrokerConfiguration.shipExchangeQueue = exchangeQueue;
    }

    @Bean
    Queue queue() {
        return new Queue(BrokerConfiguration.shipExchangeQueue);
    }

    @Bean
    Binding bindingToDirectExchange(Queue commonQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(commonQueue).to(directExchange).with(BrokerConfiguration.shipRoutingKey);
    }

    @Bean
    Binding bindingToFanoutExchange(Queue commonQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(commonQueue).to(fanoutExchange);
    }

}
