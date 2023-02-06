package com.pastries.Pastries.exception;

public class CakeNotFoundException extends RuntimeException{
    public CakeNotFoundException(String message) {
        super(message);
    }
}
