package com.example.SerhalAndSerhal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductNotFoundException extends RuntimeException {
    private String message;
    public ProductNotFoundException(String message) {
        super(message);
    }
}
