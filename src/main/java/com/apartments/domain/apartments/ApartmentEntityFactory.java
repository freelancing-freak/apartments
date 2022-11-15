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
                .images(insertImages(apartment))
                .build();
    }

    private static List<String> insertImages(Apartment apartment) {
        List<String> images = new LinkedList<>();
        images.add(apartment.getImage1());
        images.add(apartment.getImage2());
        images.add(apartment.getImage3());
        images.add(apartment.getImage4());
        images.add(apartment.getImage5());
        images.add(apartment.getImage6());
        images.add(apartment.getImage7());
        images.add(apartment.getImage8());
        images.add(apartment.getImage9());
        return images;
    }
}
