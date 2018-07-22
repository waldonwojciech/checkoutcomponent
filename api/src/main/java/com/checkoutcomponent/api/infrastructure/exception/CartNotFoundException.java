package com.checkoutcomponent.api.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Cart not found.")
public class CartNotFoundException extends RuntimeException {
}
