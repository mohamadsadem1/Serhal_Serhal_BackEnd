package com.example.SerhalAndSerhal.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LocationAlreadyExistException extends RuntimeException {
    private String message;
    public LocationAlreadyExistException(String message) {
        super(message);
    }
}
