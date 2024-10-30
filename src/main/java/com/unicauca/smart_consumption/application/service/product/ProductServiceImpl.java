package com.unicauca.smart_consumption.application.service.product;

import com.unicauca.smart_consumption.domain.common.ResponseDto;
import com.unicauca.smart_consumption.domain.constant.MessagesConstant;
import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.product.ports.in.IProductService;
import com.unicauca.smart_consumption.domain.product.ports.out.IProductRepository;
import com.unicauca.smart_consumption.infrastructure.exception.BusinessRuleException;
import com.unicauca.smart_consumption.infrastructure.messages.MessageLoader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productCommandRepository;

    @Override
    public ResponseDto<Product> createProduct(Product product) {

        Product productNew = productCommandRepository.createProduct(product);

        return new ResponseDto<>(HttpStatus.CREATED.value(),
            MessageLoader.getInstance().getMessage(MessagesConstant.IM002), productNew);
   
    }

    @Override
    public ResponseDto<Product> updateProduct(String id, Product product) {
        Product productUpdated = productCommandRepository.updateProduct(id, product);
        return new ResponseDto<>(HttpStatus.OK.value(),
            MessageLoader.getInstance().getMessage(MessagesConstant.IM003), productUpdated);    
    }

    @Override
    public ResponseDto<Void> deleteProduct(String id) {
        productCommandRepository.deleteProduct(id);
        return new ResponseDto<>(HttpStatus.OK.value(),
            MessageLoader.getInstance().getMessage(MessagesConstant.IM004));
        
    }

    @Override
    public ResponseDto<Product> findProductById(final String id) {
        Product product = productCommandRepository.findProductById(id)
            .orElseThrow(() -> new BusinessRuleException(HttpStatus.BAD_REQUEST.value(), MessagesConstant.EM002,
                MessageLoader.getInstance().getMessage(MessagesConstant.EM002, id)));
        return new ResponseDto<>(HttpStatus.OK.value(),
            MessageLoader.getInstance().getMessage(MessagesConstant.IM001), product);
    }

    @Override
    public ResponseDto<List<Product>> findAllProducts() {
        List<Product> products = productCommandRepository.findAllProducts();
        return new ResponseDto<>(HttpStatus.OK.value(),
            MessageLoader.getInstance().getMessage(MessagesConstant.IM001), products);
    }

}
