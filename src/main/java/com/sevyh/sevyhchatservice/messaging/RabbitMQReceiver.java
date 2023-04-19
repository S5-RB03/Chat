// RabbitMQReceiver.java
package com.sevyh.sevyhchatservice.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receive(Object message) {
        
        System.out.println("Received message: " + message);
    }
}
