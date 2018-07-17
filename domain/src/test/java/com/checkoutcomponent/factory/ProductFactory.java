package com.checkoutcomponent.factory;

import com.checkoutcomponent.model.product.Product;

public class ProductFactory {

    public static Product createProduct() {
        return new Product("name");
    }
}
