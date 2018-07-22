package com.checkoutcomponent.api.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Cart already exists.")
public class CartAlreadyExistsException extends RuntimeException {
}
