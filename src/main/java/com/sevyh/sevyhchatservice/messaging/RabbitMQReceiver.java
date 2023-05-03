// RabbitMQReceiver.java
package com.sevyh.sevyhchatservice.messaging;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevyh.sevyhchatservice.api.model.Message;
import com.sevyh.sevyhchatservice.service.MessageService;

@Service
public class RabbitMQReceiver {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receive(byte[] payload) {
        System.out.println("Received message: " + payload);

        try {
            Message savedMessage = messageService.saveMessage(objectMapper.readValue(payload, Message.class));
            System.out.println("Saved message: " + savedMessage);
        } catch (IOException e) {
            System.out.println("Error while parsing message: " + e.getMessage());
        }
        
    }
}
