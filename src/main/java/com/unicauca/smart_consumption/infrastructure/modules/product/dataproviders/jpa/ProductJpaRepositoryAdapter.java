package com.unicauca.smart_consumption.infrastructure.modules.product.dataproviders.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.product.ports.out.IProductRepository;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductJpaMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductJpaRepositoryAdapter implements IProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductJpaMapper productPostgresMapper;
    @Override
    public Product createProduct(Product product) {
        ProductJpaEntity entity = productPostgresMapper.toTarget(product);
        final var productCreated = productPostgresMapper.toDomain(productJpaRepository.save(entity));
        return productCreated;
    }

    @Override
    public void deleteProduct(String id) {
        if (productJpaRepository.existsById(id)) {
            productJpaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Product not found with id " + id);
        }
    }

    @Override
    public Optional<Product> findProductById(String id) {
        return productJpaRepository.findById(id)
            .map(productPostgresMapper::toDomain);
    }

    @Override
    public List<Product> findAllProducts() {
        return productJpaRepository.findAll().stream()
            .map(productPostgresMapper::toDomain)
            .toList();
    }

    @Override
    public List<Product> findAllByIdIn(List<String> ids) {
        return this.productJpaRepository.findAllById(ids).
            stream().map(productPostgresMapper::toDomain).toList();
    }
}
