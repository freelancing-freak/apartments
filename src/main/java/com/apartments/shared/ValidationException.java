package com.apartments.shared;

public abstract class ValidationException extends RuntimeException {

    public static String label;

    public ValidationException(String message) {
        super(message);
        label = message;
    }
}
