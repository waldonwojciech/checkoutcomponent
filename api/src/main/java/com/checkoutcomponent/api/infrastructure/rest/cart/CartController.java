package com.checkoutcomponent.api.infrastructure.rest.cart;

import com.checkoutcomponent.api.infrastructure.exception.CartAlreadyExistsException;
import com.checkoutcomponent.api.infrastructure.exception.CartNotFoundException;
import com.checkoutcomponent.api.infrastructure.exception.ProductNotFoundException;
import com.checkoutcomponent.api.infrastructure.service.cart.CartService;
import com.checkoutcomponent.api.infrastructure.service.discount.DiscountService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/open", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity openCart(@RequestParam("customerId") String customerId) {
        try {
            cartService.openCart(customerId);
        } catch (CartAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(value = "/scan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity scanItem(@RequestParam("customerId") String customerId, @RequestParam("productId") String productId, @RequestParam("quantity") int quantity) {
        try {
            cartService.scanProduct(customerId, productId, quantity);
        } catch (CartNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        } catch (ProductNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        return ResponseEntity
                .ok()
                .build();
    }


    @RequestMapping(value = "/close", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity closeCart(@RequestParam("customerId") String customerId) {
        BigDecimal discountAmount;
        try {
            discountAmount = discountService.getDiscountsAmountForCustomerId(customerId);
        } catch (CartNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
        cartService.closeCart(customerId);

        return ResponseEntity
                .ok(discountAmount);
    }
}
