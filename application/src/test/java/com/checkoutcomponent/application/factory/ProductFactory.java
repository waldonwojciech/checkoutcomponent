package com.checkoutcomponent.application.factory;

import com.checkoutcomponent.domain.model.product.Product;

import java.util.Arrays;
import java.util.List;

public class ProductFactory {

    private static final String FIRST_PRODUCT = "FIRST_PRODUCT";
    private static final String SECOND_PRODUCT = "SECOND_PRODUCT";
    private static Product firstProduct;
    private static Product secondProduct;

    static {
        firstProduct = new Product(FIRST_PRODUCT);
        firstProduct.setId(FIRST_PRODUCT);

        secondProduct = new Product(SECOND_PRODUCT);
        secondProduct.setId(SECOND_PRODUCT);
    }

    static Product getFirstProduct() {
        return firstProduct;
    }

    public static Product getSecondProduct() {
        return firstProduct;
    }

    public static List<Product> createList() {
        return Arrays.asList(firstProduct, secondProduct);
    }
}
