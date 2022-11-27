package com.apartments.domain.apartments

import com.apartments.domain.apartments.exception.InvalidApartmentException
import com.apartments.shared.exception.ValidationException
import spock.lang.Specification
import spock.lang.Unroll

import java.time.ZonedDateTime

class ApartmentValidatorSpec extends Specification {

    private def validator = new ApartmentValidator()

    @Unroll
    def 'Should throw an exception cause some of fields are invalid'(InvalidApartmentException.CAUSE cause,
                                                                     name,
                                                                     description,
                                                                     location,
                                                                     locationSrc,
                                                                     measurement,
                                                                     numberOfRooms,
                                                                     price,
                                                                     mainImage,
                                                                     images) {
        given:
        def apartment = new Apartment(1L, ZonedDateTime.now().toString(),
                name,
                description,
                location,
                locationSrc,
                measurement,
                numberOfRooms,
                price,
                mainImage,
                images)

        when:
        validator.validate(apartment)

        then: 'exception is thrown'
        ValidationException exception = thrown()
        exception.message == cause.message

        where:
        cause                                                            | name        | description | location    | locationSrc     | measurement | numberOfRooms | price   | mainImage      | images                    | _
        InvalidApartmentException.CAUSE.EMPTY_NAME                       | null        | 'desc'      | 'barcelona' | 'barcelona 2/3' | 63          | 3             | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_DESCRIPTION                | 'Apartment' | null        | 'barcelona' | 'barcelona 2/3' | 63          | 3             | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_LOCATION                   | 'Apartment' | 'desc'      | null        | 'barcelona 2/3' | 63          | 3             | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_LOCATION_SRC               | 'Apartment' | 'desc'      | 'barcelona' | null            | 63          | 3             | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_MEASUREMENT                | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | 0           | 3             | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_MEASUREMENT                | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | -1          | 3             | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_NUMBER_OF_ROOMS            | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | 63          | 0             | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_NUMBER_OF_ROOMS            | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | 63          | -1            | '63500' | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_PRICE                      | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | 63          | 3             | null    | 'url to image' | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.EMPTY_MAIN_IMAGE                 | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | 63          | 3             | '63500' | null           | List.of('url to image 1') | _
        InvalidApartmentException.CAUSE.MINIMUM_SINGLE_IMAGE_IS_REQUIRED | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | 63          | 3             | '63500' | 'url to image' | null                      | _
        InvalidApartmentException.CAUSE.MINIMUM_SINGLE_IMAGE_IS_REQUIRED | 'Apartment' | 'desc'      | 'barcelona' | 'barcelona 2/3' | 63          | 3             | '63500' | 'url to image' | List.of()                 | _
    }
}
