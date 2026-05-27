package com.fitness.aiservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.queue.name}")
    private String queue;

    // Queue
    @Bean
    public Queue activityQueue() {
        return new Queue(queue);
    }

    // Exchange
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    // Binding Queue with Exchange
    @Bean
    public Binding binding(Queue activityQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(activityQueue)
                .to(exchange)
                .with(routingKey);
    }

    // JSON Converter
    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper typeMapper = 
                new org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper();
        java.util.Map<String, Class<?>> idClassMapping = new java.util.HashMap<>();
        idClassMapping.put("com.fitness.activityservice.model.Activity", com.fitness.aiservice.model.Activity.class);
        typeMapper.setIdClassMapping(idClassMapping);
        typeMapper.setTrustedPackages("*");

        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter(objectMapper);
        converter.setJavaTypeMapper(typeMapper);
        return converter;
    }
}