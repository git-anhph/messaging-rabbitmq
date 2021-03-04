package com.anhph.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.anhph.rabbitmqdemo.AMQConstants.BINDING_PATTERN_ERROR;
import static com.anhph.rabbitmqdemo.AMQConstants.BINDING_PATTERN_IMPORTANT;
import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_QUEUE_1_NAME;
import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_QUEUE_2_NAME;
import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_QUEUE_3_NAME;

@Component
public class Consumer {
    @RabbitListener(queues = {TOPIC_QUEUE_1_NAME})
    public void receiveMessageFromTopic1(String message) {
        System.out.println("Received topic 1 (" + BINDING_PATTERN_IMPORTANT + ") message: " + message);
    }
    
    @RabbitListener(queues = {TOPIC_QUEUE_2_NAME})
    public void receiveMessageFromTopic2(String message) {
        System.out.println("Received topic 2 (" + BINDING_PATTERN_ERROR + ") message: " + message);
    }
    
    @RabbitListener(queues = {TOPIC_QUEUE_3_NAME})
    public void receiveMessageFromTopic3(String message) {
        System.out.println("Received topic 3 (" + BINDING_PATTERN_IMPORTANT + ") message: " + message);
    }
}
