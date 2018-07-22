package com.checkoutcomponent.api.factory;

import com.checkoutcomponent.domain.model.product.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductFactory {

    private static final String FIRST_PRODUCT = "FIRST_PRODUCT";
    private static final String SECOND_PRODUCT = "SECOND_PRODUCT";

    private static final BigDecimal FIRST_PRODUCT_DISCOUNT_AMOUNT_PRICE = BigDecimal.valueOf(30L);
    private static final BigDecimal SECOND_PRODUCT_DISCOUNT_AMOUNT_PRICE = BigDecimal.valueOf(30L);

    public static final BigDecimal PRODUCTS_TOTAL_PRICE = FIRST_PRODUCT_DISCOUNT_AMOUNT_PRICE.add(SECOND_PRODUCT_DISCOUNT_AMOUNT_PRICE);

    private static Product firstProduct;
    private static Product secondProduct;

    static {
        firstProduct = new Product(FIRST_PRODUCT, FIRST_PRODUCT_DISCOUNT_AMOUNT_PRICE);
        firstProduct.setId(FIRST_PRODUCT);

        secondProduct = new Product(SECOND_PRODUCT, SECOND_PRODUCT_DISCOUNT_AMOUNT_PRICE);
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
