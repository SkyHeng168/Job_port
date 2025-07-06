package com.AlphaTech.AlphaDevelopment.excption.customException;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}