package com.checkoutcomponent.application.factory;

import com.checkoutcomponent.domain.model.cart.Cart;

public class CartFactory {

    public static Cart create() {
        Cart cart = new Cart();
        cart.setProducts(ProductFactory.createList());

        return cart;
    }
}
