package com.apartments.domain.apartments.exception;

import com.apartments.shared.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class InvalidApartmentException extends ValidationException {

    @Getter
    @AllArgsConstructor
    public enum CAUSE {
        EMPTY_NAME("Proszę podać nazwę"),
        EMPTY_DESCRIPTION("Proszę podać opis"),
        EMPTY_LOCATION("Proszę podać lokalizację (opis)"),
        EMPTY_LOCATION_SRC("Proszę podać link do lokalizacji (Google Maps)"),
        EMPTY_MEASUREMENT("Proszę podać metraż"),
        EMPTY_NUMBER_OF_ROOMS("Proszę podać liczbę pokoi"),
        EMPTY_PRICE("Proszę podać cenę"),
        EMPTY_MAIN_IMAGE("Proszę podać link do głównego zdjęcia");

        final String message;
    }

    public InvalidApartmentException(CAUSE cause) {
        super(cause.message);
    }
}
