package com.apartments.domain.apartments;

import com.apartments.shared.utils.DateConverter;

import java.util.List;

public record ApartmentVO(long id,
                          String createdDate,
                          String name,
                          String description,
                          String location,
                          String locationSrc,
                          int measurement,
                          int numberOfRooms,
                          String price,
                          String mainImage,
                          List<String> images) {

    public static ApartmentVO from(ApartmentEntity entity) {
        return new ApartmentVO(entity.getId(),
                DateConverter.convert(entity.getCreatedDate()),
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
