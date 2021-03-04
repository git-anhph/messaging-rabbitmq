package com.anhph.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.anhph.rabbitmqdemo.AMQConstants.TOPIC_EXCHANGE_NAME;

@RestController
public class SendMessageController {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @PostMapping(value = "/send")
    public String sendMessage(@RequestBody Criteria criteria) {
        rabbitTemplate.convertAndSend(
                            TOPIC_EXCHANGE_NAME,
                            criteria.getRoutingKey(),
                            criteria.getMessage());
        return "OK";
    }
    
}
