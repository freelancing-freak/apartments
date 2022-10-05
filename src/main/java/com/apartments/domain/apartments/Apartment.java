package com.apartments.domain.apartments;

import java.util.Set;

public record Apartment(long id,
                        String name,
                        String description,
                        String location,
                        String locationSrc,
                        int measurement,
                        int numberOfRooms,
                        String price,
                        String mainImage,
                        Set<String> images) {

    public static Apartment from(ApartmentEntity entity) {
        return new Apartment(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getLocation(),
                entity.getLocationSrc(),
                entity.getMeasurement(),
                entity.getNumberOfRooms(),
                entity.getPrice(),
                entity.getMainImage(),
                entity.getImages());
    }
}
