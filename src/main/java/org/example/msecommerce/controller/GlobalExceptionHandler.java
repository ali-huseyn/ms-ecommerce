package org.example.msecommerce.controller;

import org.example.msecommerce.dto.ExceptionResponse;
import org.example.msecommerce.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)

    public ExceptionResponse handleProductNotFoundException(ProductNotFoundException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND.toString());
    }

}
