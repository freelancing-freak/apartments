package com.apartments.domain.apartments;

import com.apartments.domain.apartments.exception.InvalidApartmentException;
import org.springframework.stereotype.Component;

@Component
public class ApartmentValidator {

    public void validate(Apartment apartment) {
        InvalidApartmentException.CAUSE cause = null;
        if (isBlankOrEmpty(apartment.getName())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_NAME;
        } else if (isBlankOrEmpty(apartment.getDescription())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_DESCRIPTION;
        } else if (isBlankOrEmpty(apartment.getLocation())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_LOCATION;
        } else if (isBlankOrEmpty(apartment.getLocationSrc())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_LOCATION_SRC;
        } else if (isLessOrEqualsZero(apartment.getMeasurement())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_MEASUREMENT;
        } else if (isLessOrEqualsZero(apartment.getNumberOfRooms())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_NUMBER_OF_ROOMS;
        } else if (isBlankOrEmpty(apartment.getPrice())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_PRICE;
        } else if (isBlankOrEmpty(apartment.getMainImage())) {
            cause = InvalidApartmentException.CAUSE.EMPTY_MAIN_IMAGE;
        } else if (apartment.getImages() == null || apartment.getImages().size() < 1) {
            cause = InvalidApartmentException.CAUSE.MINIMUM_SINGLE_IMAGE_IS_REQUIRED;
        }
        if (cause != null) {
            throw new InvalidApartmentException(cause);
        }
    }

    boolean isBlankOrEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    boolean isLessOrEqualsZero(int num) {
        return num <= 0;
    }
}
