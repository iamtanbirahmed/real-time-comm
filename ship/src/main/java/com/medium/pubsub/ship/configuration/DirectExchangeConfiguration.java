package com.medium.pubsub.ship.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfiguration {

    private static String directExchange;

    @Value("${broker.exchange.direct.ship.name}")
    private void setDirectExchangeName(String topicExchange) {
        DirectExchangeConfiguration.directExchange = topicExchange;
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DirectExchangeConfiguration.directExchange);
    }
}
