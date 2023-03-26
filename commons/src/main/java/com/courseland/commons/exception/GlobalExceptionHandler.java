package com.courseland.commons.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotfoundException(ResourceNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails(NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(errorDetails, NOT_FOUND);
    }
}
