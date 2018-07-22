package com.checkoutcomponent.api.infrastructure.service.cart;

import com.checkoutcomponent.api.infrastructure.exception.CartAlreadyExistsException;
import com.checkoutcomponent.api.infrastructure.exception.CartNotFoundException;
import com.checkoutcomponent.api.infrastructure.exception.ProductNotFoundException;
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

    public void openCart(String customerId) throws CartAlreadyExistsException {
        isCartAlreadyExists(customerId);

        Cart cart = new Cart(customerId);
        cartRepository.save(cart);
    }

    private void isCartAlreadyExists(String customerId) throws CartAlreadyExistsException {
        if (cartRepository.findById(customerId).isPresent())
            throw new CartAlreadyExistsException();
    }

    public void closeCart(String customerId) {
        cartRepository.deleteById(customerId);
    }

    public void scanProduct(String customerId, String productId, int quantity) throws CartNotFoundException, ProductNotFoundException {
        Cart customerCart = getCartForCustomerId(customerId);
        Product customerProduct = getCustomerProduct(productId);

        for (int i = 0; i < quantity; i++) {
            customerCart.getProducts().add(customerProduct);
        }

        cartRepository.save(customerCart);
    }

    private Product getCustomerProduct(String productId) throws ProductNotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }

    private Cart getCartForCustomerId(String customerId) throws CartNotFoundException {
        return cartRepository.findById(customerId)
                .orElseThrow(CartNotFoundException::new);
    }
}
