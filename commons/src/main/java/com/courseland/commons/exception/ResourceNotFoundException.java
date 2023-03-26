package com.courseland.commons.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName) {
        super(String.format("%s not found with %s!", resourceName, fieldName));
    }
}
