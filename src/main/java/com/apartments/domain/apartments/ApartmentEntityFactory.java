package com.apartments.domain.apartments;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentEntityFactory {

    public static ApartmentEntity create(Apartment apartment) {
        return ApartmentEntity.builder()
                .name(apartment.getName())
                .description(apartment.getDescription())
                .location(apartment.getLocation())
                .locationSrc(apartment.getLocationSrc())
                .measurement(apartment.getMeasurement())
                .numberOfRooms(apartment.getNumberOfRooms())
                .price(apartment.getPrice())
                .mainImage(apartment.getMainImage())
                .images(apartment.getImages())
                .build();
    }
}
