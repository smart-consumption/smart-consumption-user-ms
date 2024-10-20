package com.unicauca.smart_consumption.infrastructure.modules.user.publisher;

import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.user.User;
import com.unicauca.smart_consumption.domain.user.ports.out.IUserEventPublisher;
import com.unicauca.smart_consumption.infrastructure.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.unicauca.smart_consumption.infrastructure.config.RabbitMQConfig.ROUTING_KEY_USER_CREATED;
import static com.unicauca.smart_consumption.infrastructure.config.RabbitMQConfig.ROUTING_KEY_USER_UPDATED;

@Component
public class UserPublisher implements IUserEventPublisher {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishUserCreated(User user) {
        System.out.println("Send message queue: " + user);
        rabbitTemplate.convertAndSend(RabbitMQConfig.USER_EXCHANGE, ROUTING_KEY_USER_CREATED , user);
    }

    @Override
    public void publishUserUpdated(User user) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.USER_EXCHANGE, ROUTING_KEY_USER_UPDATED, user);
    }
}
