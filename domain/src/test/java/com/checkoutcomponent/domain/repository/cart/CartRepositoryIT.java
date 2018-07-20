package com.checkoutcomponent.domain.repository.cart;

import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.repository.BaseRepositoryTest;
import com.checkoutcomponent.factory.CartFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryIT extends BaseRepositoryTest {

    @Test
    public void shouldCreateOpenCart() {
        //given
        Cart cart = CartFactory.create();

        //when
        cartRepository.save(cart);

        //then
        assertEquals(1, cartRepository.count());
    }
}
