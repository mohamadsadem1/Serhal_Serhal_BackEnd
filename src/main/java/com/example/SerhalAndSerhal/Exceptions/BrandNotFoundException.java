package com.example.SerhalAndSerhal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public class BrandNotFoundException  extends RuntimeException {
        private String message;
        public BrandNotFoundException(String message) {
            super(message);
        }
    }

