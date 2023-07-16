package com.example.SerhalAndSerhal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductAlreadyExistException  extends RuntimeException{

        private String message;
        public ProductAlreadyExistException(String message) {
            super(message);
        }
    }


