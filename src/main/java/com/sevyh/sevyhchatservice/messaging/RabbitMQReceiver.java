// RabbitMQReceiver.java
package com.sevyh.sevyhchatservice.messaging;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevyh.sevyhchatservice.api.model.Message;

@Service
public class RabbitMQReceiver {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${rabbitmq.storage.queue}")
    public void receiveForStorage(byte[] payload) {
        // process messages for storage
        processMessage(payload);
    }
    
    @RabbitListener(queues = "${rabbitmq.communication.queue}")
    public void receiveForCommunication(byte[] payload) {
        // process messages for communication
        processMessage(payload);
    }

    private void processMessage(byte[] payload) {
        System.out.println("Received message: " + new String(payload));
        
        try {
            Message message = objectMapper.readValue(new String(payload), Message.class);
            System.out.println("Received message: " + message);
        } catch (IOException e) {
            System.out.println("Error while parsing message: " + e.getMessage());
        }
    }
    
    
}

