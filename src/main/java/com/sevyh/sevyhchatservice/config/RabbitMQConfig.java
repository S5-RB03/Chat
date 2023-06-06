package com.sevyh.sevyhchatservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.storage.queue}")
    private String storageQueueName;

    @Value("${rabbitmq.storage.exchange}")
    private String storageExchangeName;

    @Value("${rabbitmq.storage.routingKey}")
    private String storageRoutingKey;

    @Value("${rabbitmq.communication.queue}")
    private String communicationQueueName;

    @Value("${rabbitmq.communication.exchange}")
    private String communicationExchangeName;

    @Value("${rabbitmq.communication.routingKey}")
    private String communicationRoutingKey;

    @Bean
    public Queue storageQueue() {
        return new Queue(storageQueueName, true);
    }

    @Bean
    public Queue communicationQueue() {
        return new Queue(communicationQueueName, true);
    }

    @Bean
    public TopicExchange storageExchange() {
        return new TopicExchange(storageExchangeName);
    }

    @Bean
    public TopicExchange communicationExchange() {
        return new TopicExchange(communicationExchangeName);
    }

    @Bean
    public Binding storageBinding(Queue storageQueue, TopicExchange storageExchange) {
        return BindingBuilder.bind(storageQueue).to(storageExchange).with(storageRoutingKey);
    }

    @Bean
    public Binding communicationBinding(Queue communicationQueue, TopicExchange communicationExchange) {
        return BindingBuilder.bind(communicationQueue).to(communicationExchange).with(communicationRoutingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

