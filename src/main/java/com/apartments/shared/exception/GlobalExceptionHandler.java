package com.apartments.shared.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handle(ValidationException exception) {
        final String label = exception.getLabel();
        log.error("{} has been thrown: {}", exception.getClass(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(label);
    }

    @ExceptionHandler(Exception.class)
    public Exception handle(Exception exception) {
        log.error("{} has been thrown: {}", exception.getClass(), exception.getMessage());
        return exception;
    }
}
