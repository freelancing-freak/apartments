package com.apartments.application.api.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

public record ApartmentRequest(@NotEmpty String name,
                               @NotEmpty String description,
                               @NotEmpty String location,
                               @NotEmpty String locationSrc,
                               @NotEmpty int measurement,
                               @NotEmpty int numberOfRooms,
                               @NotEmpty String price,
                               @NotEmpty String mainImage,
                               @NotEmpty Set<String> images) {
}
