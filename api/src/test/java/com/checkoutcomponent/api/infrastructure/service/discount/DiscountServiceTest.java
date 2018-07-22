package com.checkoutcomponent.api.infrastructure.service.discount;

import com.checkoutcomponent.api.factory.CartFactory;
import com.checkoutcomponent.api.factory.DiscountFactory;
import com.checkoutcomponent.api.factory.ProductFactory;
import com.checkoutcomponent.api.infrastructure.exception.CartNotFoundException;
import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.discount.Discount;
import com.checkoutcomponent.domain.repository.cart.CartRepository;
import com.checkoutcomponent.domain.repository.discount.DiscountRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class DiscountServiceTest {

    private static final String CUSTOMER_ID = "customerId";

    @Mock
    private CartRepository cartRepository;

    @Mock
    private DiscountRepository discountRepository;

    @InjectMocks
    private DiscountService discountService;

    @BeforeMethod(alwaysRun = true)
    public void injectDoubles() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should() throws CartNotFoundException {
        //given
        Cart cart = CartFactory.create();
        List<Discount> discounts = DiscountFactory.createList();

        //when
        when(cartRepository.findById(CUSTOMER_ID)).thenReturn(Optional.of(cart));
        when(discountRepository.findAll()).thenReturn(discounts);

        BigDecimal discountAmount = discountService.getTotalPrice(CUSTOMER_ID);

        //then
        BigDecimal finalProductsPrice = ProductFactory.PRODUCTS_TOTAL_PRICE.subtract(DiscountFactory.PRODUCTS_DISCOUNT_AMOUNT);
        assertEquals(finalProductsPrice, discountAmount);
    }
}
