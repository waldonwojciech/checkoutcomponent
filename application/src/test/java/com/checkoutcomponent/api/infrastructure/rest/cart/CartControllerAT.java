package com.checkoutcomponent.api.infrastructure.rest.cart;

import com.checkoutcomponent.api.infrastructure.WebRestConfigClassTest;
import com.checkoutcomponent.domain.model.cart.Cart;
import com.checkoutcomponent.domain.model.discount.Discount;
import com.checkoutcomponent.domain.model.product.Product;
import com.checkoutcomponent.domain.repository.cart.CartRepository;
import com.checkoutcomponent.domain.repository.discount.DiscountRepository;
import com.checkoutcomponent.domain.repository.product.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class CartControllerAT extends WebRestConfigClassTest {

    private static final String CUSTOMER_ID = "customerId";
    private static final String CREATED_CART_FOR_CUSTOMER_ID = "createdCartForCustomerId";
    private static final String PRODUCT_NAME = "productName";
    private MockMvc mockMvc;

    @Autowired
    private CartController cartController;

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
    }

    @Test
    public void shouldOpenCart() throws Exception {
        mockMvc.perform(post("/cart/open?customerId=" + CUSTOMER_ID))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldScanItem() throws Exception {
        //given
        Product product = getProduct(PRODUCT_NAME);
        Cart cart = getOpenCartForCustomerId(CREATED_CART_FOR_CUSTOMER_ID, product);

        //when
        Discount discount = getDiscount(product);

        //then
        String uri = "/cart/scan?customerId=" + CREATED_CART_FOR_CUSTOMER_ID
                + "&productId=" + product.getId()
                + "&quantity=" + 1;
        mockMvc.perform(post(uri))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCloseCart() throws Exception {
        //given
        openCartForCustomerId(CREATED_CART_FOR_CUSTOMER_ID);

        //then
        MvcResult result = mockMvc.perform(post("/cart/close?customerId=" + CREATED_CART_FOR_CUSTOMER_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        assertEquals("0", result.getResponse().getContentAsString());
    }

    private Discount getDiscount(Product product) {
        Discount discount = new Discount();
        discount.getProducts().put(product, 1l);

        return discountRepository.save(discount);
    }

    private Cart openCartForCustomerId(String customerId) {
        Cart cart = new Cart(customerId);

        return cartRepository.save(cart);
    }

    private Product getProduct(String productName) {
        Product product = new Product(productName);

        return productRepository.save(product);
    }

    private Cart getOpenCartForCustomerId(String customerId, Product product) {
        Cart cart = new Cart(customerId);
        cart.getProducts().add(product);

        return cartRepository.save(cart);
    }


}
