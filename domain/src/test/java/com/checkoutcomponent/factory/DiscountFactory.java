package com.checkoutcomponent.factory;

import com.checkoutcomponent.domain.model.product.Product;
import com.checkoutcomponent.domain.model.discount.Discount;

import java.math.BigDecimal;

public class DiscountFactory {

    public static Discount create(Product product) {
        Discount discount = new Discount();
        discount.getProducts().put(2, product);
        discount.setDiscountAmount(BigDecimal.TEN);

        return discount;
    }
}
