package com.checkoutcomponent.application.infrastructure.service.cart;

import com.checkoutcomponent.application.infrastructure.exception.CartNotFoundException;
import com.checkoutcomponent.application.infrastructure.exception.ProductNotFoundException;
import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.product.Product;
import com.checkoutcomponent.domain.repository.cart.CartRepository;
import com.checkoutcomponent.domain.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void closeCart(String customerId) {
        cartRepository.deleteById(customerId);
    }

    public void scanProduct(String customerId, Product product, int quantity) throws CartNotFoundException, ProductNotFoundException {
        Cart customerCart = getCartForCustomerId(customerId);
        Product customerProduct = getCustomerProduct(product);

        customerCart.getProducts().add(customerProduct)
    }

    private Product getCustomerProduct(Product product) throws ProductNotFoundException {
        return productRepository.findById(product.getId())
                .orElseThrow(ProductNotFoundException::new);
    }

    private Cart getCartForCustomerId(String customerId) throws CartNotFoundException {
        return cartRepository.findById(customerId)
                .orElseThrow(CartNotFoundException::new);
    }
}
