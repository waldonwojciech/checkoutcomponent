package com.checkoutcomponent.factory;

import com.checkoutcomponent.domain.model.product.Product;

public class ProductFactory {

    public static Product create() {
        return new Product("name");
    }
}
