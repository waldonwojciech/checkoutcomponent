package com.checkoutcomponent.api.infrastructure.rest.cart;

import com.checkoutcomponent.application.infrastructure.service.cart.CartService;
import com.checkoutcomponent.domain.model.product.Product;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping(value = "/cart")
@Log4j
public class CartController {

    @Autowired
    private CartService cartService;

    //todo
    @RequestMapping(value = "/open", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity openCart(@RequestParam("customerId") String customerId) {
        return ResponseEntity.ok().build();
    }

    //todo
    @RequestMapping(value = "/scan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity scanItem(@RequestParam("customerId") String customerId, @RequestParam("product") Product product, @RequestParam("quantity") String quantity) {
        return ResponseEntity.ok().build();
    }

    //todo
    @RequestMapping(value = "/close", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity closeCart(@RequestParam("customerId") String customerId) {
        return ResponseEntity.ok().build();
    }
}
