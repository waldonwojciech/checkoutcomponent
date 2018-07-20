package com.checkoutcomponent.factory;

import com.checkoutcomponent.domain.model.cart.Cart;

public class CartFactory {

    public static Cart create() {
        return new Cart("customerId");
    }
}
