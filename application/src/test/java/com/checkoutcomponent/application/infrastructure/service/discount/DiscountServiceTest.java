package com.checkoutcomponent.application.infrastructure.service.discount;

import com.checkoutcomponent.application.factory.CartFactory;
import com.checkoutcomponent.application.factory.DiscountFactory;
import com.checkoutcomponent.application.factory.ProductFactory;
import com.checkoutcomponent.application.infrastructure.exception.CartNotFoundException;
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

        BigDecimal discountAmount = discountService.getDiscountsAmountForCustomerId(CUSTOMER_ID);

        //then
        assertEquals(DiscountFactory.PRODUCTS_DISCOUNT_AMOUNT, discountAmount);
    }
}
