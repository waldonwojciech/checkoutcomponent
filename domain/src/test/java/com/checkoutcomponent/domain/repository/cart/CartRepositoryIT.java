package com.checkoutcomponent.domain.repository.cart;

import com.checkoutcomponent.TestSpringBootApplicationClass;
import com.checkoutcomponent.factory.CartFactory;
import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.repository.BaseRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestSpringBootApplicationClass.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
@WebAppConfiguration
public class CartRepositoryIT extends BaseRepositoryTest {

    @Test
    public void shouldCreateOpenCart() {
        //given
        Cart cart = CartFactory.createOpenCart();

        //when
        cartRepository.save(cart);

        //then
        assertEquals(1, cartRepository.count());
    }
}
