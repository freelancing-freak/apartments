package com.apartments.shared.exception;

import lombok.Getter;

@Getter
public abstract class ValidationException extends RuntimeException {

    private final String label;

    public ValidationException(String message) {
        super(message);
        label = message;
    }
}
