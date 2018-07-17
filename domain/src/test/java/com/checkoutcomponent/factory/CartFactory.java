package com.checkoutcomponent.factory;

import com.checkoutcomponent.domain.model.cart.Cart;

public class CartFactory {

    public static Cart createOpenCart() {
        return new Cart("customerId");
    }
}
