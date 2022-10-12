package com.apartments.application.api.dto;

import javax.validation.constraints.NotNull;
import java.util.Set;

public record ApartmentRequest(@NotNull String name,
                               @NotNull String description,
                               @NotNull String location,
                               @NotNull String locationSrc,
                               @NotNull int measurement,
                               @NotNull int numberOfRooms,
                               @NotNull String price,
                               @NotNull String mainImage,
                               @NotNull Set<String> images) {
}
