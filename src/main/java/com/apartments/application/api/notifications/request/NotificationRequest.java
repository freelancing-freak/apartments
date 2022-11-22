package com.apartments.application.api.notifications.request;

import javax.validation.constraints.NotEmpty;

public record NotificationRequest(Long apartmentId,
                                  @NotEmpty String name,
                                  @NotEmpty String subject,
                                  @NotEmpty String phoneNumber,
                                  @NotEmpty String message) {
}
