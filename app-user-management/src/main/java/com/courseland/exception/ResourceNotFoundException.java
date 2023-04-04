package com.courseland.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName) {
        super(String.format("%s not found with %s!", resourceName, fieldName));
    }
}
