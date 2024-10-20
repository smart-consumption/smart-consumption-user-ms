package com.unicauca.smart_consumption.domain.user.ports.out;

import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.user.User;

public interface IUserEventPublisher {

    void publishUserCreated(User user);
    void publishUserUpdated(User user);

}
