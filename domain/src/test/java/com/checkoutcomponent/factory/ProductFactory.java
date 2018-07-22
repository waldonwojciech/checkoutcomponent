package com.checkoutcomponent.factory;

import com.checkoutcomponent.domain.model.product.Product;

import java.math.BigDecimal;

public class ProductFactory {

    public static Product create() {
        return new Product("name", BigDecimal.TEN);
    }
}
