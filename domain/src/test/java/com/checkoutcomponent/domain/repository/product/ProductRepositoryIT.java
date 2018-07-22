package com.checkoutcomponent.domain.repository.product;

import com.checkoutcomponent.domain.model.product.Product;
import com.checkoutcomponent.domain.repository.BaseRepositoryTest;
import com.checkoutcomponent.factory.CartFactory;
import com.checkoutcomponent.factory.ProductFactory;
import com.checkoutcomponent.domain.model.cart.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryIT extends BaseRepositoryTest {

    @Test
    public void shouldAddNewProduct() {
        //given
        Product product = ProductFactory.create();

        //when
        Product savedProduct = productRepository.save(product);

        //then
        assertEquals(product, savedProduct);
        assertEquals(1, productRepository.count());
    }

    @Test
    public void shouldAddProductToCart() {
        //given
        Cart cart = CartFactory.create();
        cartRepository.save(cart);

        Product product = ProductFactory.create();
        productRepository.save(product);

        //when
        cart.getProducts().add(product);
        cartRepository.save(cart);

        //then
        assertEquals(1, cartRepository.findById(cart.getCustomerId()).get().getProducts().size());

    }
}
