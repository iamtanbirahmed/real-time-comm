package com.medium.pubsub.ship.configuration;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfiguration {

    private static String fanoutExchange;

    @Value("${broker.exchange.fanout.name}")
    private void setFanoutExchange(String fanoutExchange) {
        FanoutExchangeConfiguration.fanoutExchange = fanoutExchange;
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FanoutExchangeConfiguration.fanoutExchange);
    }
}
