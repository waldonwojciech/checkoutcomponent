package com.checkoutcomponent.domain.repository.product;

import com.checkoutcomponent.TestSpringBootApplicationClass;
import com.checkoutcomponent.factory.CartFactory;
import com.checkoutcomponent.factory.ProductFactory;
import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.product.Product;
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
public class ProductRepositoryIT extends BaseRepositoryTest {

    @Test
    public void shouldAddNewProduct() {
        //given
        Product product = ProductFactory.createProduct();

        //when
        Product savedProduct = productRepository.save(product);

        //then
        assertEquals(product, savedProduct);
        assertEquals(1, productRepository.count());
    }

    @Test
    public void shouldAddProductToCart() {
        //given
        Cart cart = CartFactory.createOpenCart();
        cartRepository.save(cart);

        Product product = ProductFactory.createProduct();
        productRepository.save(product);
        //when
        cart.getProducts().add(product);

    }
}
