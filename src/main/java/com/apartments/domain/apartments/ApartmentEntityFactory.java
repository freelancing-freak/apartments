package com.apartments.domain.apartments;

import com.apartments.application.api.dto.ApartmentRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentEntityFactory {

    public static ApartmentEntity create(ApartmentRequest request) {
        return ApartmentEntity.builder()
                .name(request.name())
                .description(request.description())
                .location(request.location())
                .locationSrc(request.locationSrc())
                .measurement(request.measurement())
                .numberOfRooms(request.numberOfRooms())
                .price(request.price())
                .mainImage(request.mainImage())
                .images(request.images())
                .build();
    }
}
