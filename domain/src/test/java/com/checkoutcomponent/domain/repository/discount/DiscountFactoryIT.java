package com.checkoutcomponent.domain.repository.discount;

import com.checkoutcomponent.domain.model.product.Product;
import com.checkoutcomponent.domain.repository.BaseRepositoryTest;
import com.checkoutcomponent.factory.DiscountFactory;
import com.checkoutcomponent.factory.ProductFactory;
import com.checkoutcomponent.domain.model.discount.Discount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountFactoryIT extends BaseRepositoryTest {

    private Product product;

    @Before
    public void setUp() {
        product = ProductFactory.create();

        productRepository.save(product);
    }

    @After
    public void tearDown() {
        discountRepository.deleteAll();
    }

    @Test
    public void shouldAddDiscount() {
        //given
        Discount discount = DiscountFactory.create(product);

        //when
        discountRepository.save(discount);

        //then
        assertEquals(1, discountRepository.count());
    }

    @Test
    public void shouldRemoveDiscount() {
        //given
        Discount discount = DiscountFactory.create(product);
        discountRepository.save(discount);

        //when
        discountRepository.delete(discount);

        //then
        assertEquals(0, discountRepository.count());
    }
}
