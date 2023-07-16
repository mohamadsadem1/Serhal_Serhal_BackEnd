package com.example.SerhalAndSerhal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webrequest) {
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webrequest.getDescription(false),
                "Brand not found"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                              WebRequest webrequest) {
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webrequest.getDescription(false),
                "Internal Server Error"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(BrandAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleBrandDyslexicallyException(BrandAlreadyExistException exception,
                                                                         WebRequest webrequest) {
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webrequest.getDescription(false),
                "Brand Already Exist"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBrandDyslexicallyException(BrandNotFoundException exception,
                                                                         WebRequest webrequest) {
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webrequest.getDescription(false),
                "Brand Not Found"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleProductDyslexicallyException(ProductAlreadyExistException exception,
                                                                         WebRequest webrequest) {
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webrequest.getDescription(false),
                "Product Already Exist"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBrandDyslexicallyException(ProductNotFoundException exception,
                                                                         WebRequest webrequest) {
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webrequest.getDescription(false),
                "Product Not found"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }




}