package com.checkoutcomponent.api.factory;

import com.checkoutcomponent.domain.model.discount.Discount;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountFactory {

    private static final BigDecimal FIRST_PRODUCT_DISCOUNT_AMOUNT = BigDecimal.valueOf(22L);
    private static final BigDecimal SECOND_PRODUCT_DISCOUNT_AMOUNT = BigDecimal.valueOf(22L);

    public static final BigDecimal PRODUCTS_DISCOUNT_AMOUNT = FIRST_PRODUCT_DISCOUNT_AMOUNT.add(SECOND_PRODUCT_DISCOUNT_AMOUNT);
    public static List<Discount> createList() {
        Discount firstDiscount = getFirstDiscount();
        Discount secondDiscount = getSecondDiscount();

        return Arrays.asList(firstDiscount, secondDiscount);
    }

    private static Discount getFirstDiscount() {
        Discount discount = new Discount();
        Map discountProducts = new HashMap<>();
        discountProducts.put(ProductFactory.getFirstProduct(), 1L);

        discount.setProducts(discountProducts);
        discount.setDiscountAmount(FIRST_PRODUCT_DISCOUNT_AMOUNT);

        return discount;
    }

    private static Discount getSecondDiscount() {
        Discount discount = new Discount();
        Map discountProducts = new HashMap<>();
        discountProducts.put(ProductFactory.getSecondProduct(), 1L);

        discount.setProducts(discountProducts);
        discount.setDiscountAmount(SECOND_PRODUCT_DISCOUNT_AMOUNT);

        return discount;
    }
}
