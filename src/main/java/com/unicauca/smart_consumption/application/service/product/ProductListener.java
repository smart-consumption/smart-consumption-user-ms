package com.unicauca.smart_consumption.application.service.product;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.product.ports.out.IProductRepository;
import com.unicauca.smart_consumption.infrastructure.config.RabbitMQConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductListener {

    private final IProductRepository productRepository;

    @RabbitListener(queues = RabbitMQConfig.PRODUCT_CREATED_QUEUE)
    public void receiveCreatedProduct(Product product) {
        System.out.println("Product received: " + product);
        productRepository.createProduct(product);
    }
    
}
