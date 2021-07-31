package com.medium.pubsub.ship.configuration;

import com.medium.pubsub.ship.component.MessageHandler;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfiguration {

    private final BrokerConfiguration brokerConfiguration;

    public MessageListenerConfiguration(BrokerConfiguration brokerConfiguration) {
        this.brokerConfiguration = brokerConfiguration;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageHandler messageHandler) {
        return new MessageListenerAdapter(messageHandler, "handleMessage");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(brokerConfiguration.shipExchangeQueue);
        container.setMessageListener(listenerAdapter);
        return container;
    }


}
