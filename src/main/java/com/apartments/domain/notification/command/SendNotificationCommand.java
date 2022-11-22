package com.apartments.domain.notification.command;

import com.apartments.application.api.notifications.request.NotificationRequest;
import com.apartments.domain.notification.NotificationType;

public record SendNotificationCommand(NotificationType type,
                                      Long apartmentId,
                                      String name,
                                      String subject,
                                      String phoneNumber,
                                      String message) {

    public static SendNotificationCommand email(NotificationRequest request) {
        return new SendNotificationCommand(NotificationType.EMAIL,
                request.apartmentId(),
                request.name(),
                request.subject(),
                request.phoneNumber(),
                request.message());
    }
}
