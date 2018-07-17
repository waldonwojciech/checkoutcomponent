package com.checkoutcomponent.domain.repository.cart;

import com.checkoutcomponent.domain.model.cart.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
}
