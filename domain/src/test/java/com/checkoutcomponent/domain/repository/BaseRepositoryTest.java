package com.checkoutcomponent.domain.repository;

import com.checkoutcomponent.domain.repository.cart.CartRepository;
import com.checkoutcomponent.domain.repository.product.ProductRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepositoryTest {

    @Autowired
    protected CartRepository cartRepository;

    @Autowired
    protected ProductRepository productRepository;

    @Before
    public void clearDatabase() {
        cartRepository.deleteAll();
    }
}
