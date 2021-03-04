package com.anhph.rabbitmqdemo;

import lombok.Data;

@Data
public class Criteria {
    private String routingKey;
    private String message;
}
