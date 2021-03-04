package com.anhph.rabbitmqdemo;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.anhph.rabbitmqdemo.AMQConstants.BINDING_PATTERN_ERROR;
import static com.anhph.rabbitmqdemo.AMQConstants.BINDING_PATTERN_IMPORTANT;
import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_EXCHANGE_NAME;
import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_QUEUE_1_NAME;
import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_QUEUE_2_NAME;
import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_QUEUE_3_NAME;
import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Declarables topicBindings() {
        Queue topicQueue1 = new Queue(TOPIC_QUEUE_1_NAME, false);
        Queue topicQueue2 = new Queue(TOPIC_QUEUE_2_NAME, false);
        Queue topicQueue3 = new Queue(TOPIC_QUEUE_3_NAME, false);
    
        TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE_NAME);
        
        return new Declarables(
                topicQueue1,
                topicQueue2,
                topicQueue3,
                topicExchange,
                bind(topicQueue1)
                        .to(topicExchange).with(BINDING_PATTERN_IMPORTANT),
                bind(topicQueue3)
                        .to(topicExchange).with(BINDING_PATTERN_IMPORTANT),
                bind(topicQueue2)
                        .to(topicExchange).with(BINDING_PATTERN_ERROR));
    }
}
