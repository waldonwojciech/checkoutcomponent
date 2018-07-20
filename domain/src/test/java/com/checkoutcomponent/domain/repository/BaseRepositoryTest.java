package com.checkoutcomponent.domain.repository;

import com.checkoutcomponent.domain.repository.discount.DiscountRepository;
import com.checkoutcomponent.domain.repository.product.ProductRepository;
import com.checkoutcomponent.domain.repository.cart.CartRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepositoryTest {

    @Autowired
    protected CartRepository cartRepository;

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected DiscountRepository discountRepository;

    @Before
    public void tearDown() {
        cartRepository.deleteAll();
        discountRepository.deleteAll();
        productRepository.deleteAll();
    }
}
