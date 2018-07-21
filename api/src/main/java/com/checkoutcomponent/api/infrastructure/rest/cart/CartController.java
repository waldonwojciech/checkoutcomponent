package com.checkoutcomponent.api.infrastructure.rest.cart;

import com.checkoutcomponent.application.infrastructure.exception.CartNotFoundException;
import com.checkoutcomponent.application.infrastructure.exception.ProductNotFoundException;
import com.checkoutcomponent.application.infrastructure.service.cart.CartService;
import com.checkoutcomponent.application.infrastructure.service.discount.DiscountService;
import com.checkoutcomponent.domain.model.product.Product;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.math.BigDecimal;

@Controller
@EnableWebMvc
@RequestMapping(value = "/cart")
@Log4j
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private DiscountService discountService;

    @RequestMapping(value = "/open", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity openCart(@RequestParam("customerId") String customerId) {
        cartService.closeCart(customerId);

        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(value = "/scan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity scanItem(@RequestParam("customerId") String customerId, @RequestParam("product") Product product, @RequestParam("quantity") int quantity) {
        try {
            cartService.scanProduct(customerId, product, quantity);
        } catch (CartNotFoundException e) {
            e.printStackTrace();
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .ok()
                .build();
    }


    @RequestMapping(value = "/close", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity closeCart(@RequestParam("customerId") String customerId) {
        try {
            BigDecimal discountAmount = discountService.getDiscountsAmountForCustomerId(customerId);
        } catch (CartNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
        cartService.closeCart(customerId);

        return ResponseEntity
                .ok(discountService);
    }
}
