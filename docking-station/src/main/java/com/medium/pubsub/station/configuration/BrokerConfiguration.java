package com.medium.pubsub.station.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerConfiguration {
    static String directExchangeQueue;
    static String directExchange;
    static String directRoutingKey;

    @Value("${broker.exchange.direct.routing-key}")
    private void setDirectRoutingKey(String routingKey) {
        BrokerConfiguration.directRoutingKey = routingKey;
    }

    @Value("${broker.exchange.direct.name}")
    private void setDirectExchange(String exchangeName) {
        BrokerConfiguration.directExchange = exchangeName;
    }

    @Value("${broker.exchange.direct.queue.auto-queue}")
    private void setQueueName(String queueName) {
        BrokerConfiguration.directExchangeQueue = queueName;
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(BrokerConfiguration.directExchange);
    }

    @Bean
    Queue directExchangeQueue() {
        return new Queue(BrokerConfiguration.directExchangeQueue);
    }

    @Bean
    Binding updateQueueBinding(Queue directExchangeQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directExchangeQueue).to(directExchange).with(BrokerConfiguration.directRoutingKey);
    }

}
