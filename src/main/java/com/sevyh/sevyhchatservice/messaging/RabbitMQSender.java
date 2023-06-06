// RabbitMQSender.java
package com.sevyh.sevyhchatservice.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.storage.exchange}")
    private String storageExchange;

    @Value("${rabbitmq.storage.routingKey}")
    private String storageRoutingKey;
    
    @Value("${rabbitmq.communication.exchange}")
    private String communicationExchange;

    @Value("${rabbitmq.communication.routingKey}")
    private String communicationRoutingKey;

    public void sendToStorage(Object message) {
        rabbitTemplate.convertAndSend(storageExchange, storageRoutingKey, message);
    }
    
    public void sendForCommunication(Object message) {
        rabbitTemplate.convertAndSend(communicationExchange, communicationRoutingKey, message);
    }
}
