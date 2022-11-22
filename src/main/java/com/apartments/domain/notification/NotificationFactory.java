package com.apartments.domain.notification;

import com.apartments.domain.notification.command.SendNotificationCommand;
import com.apartments.domain.notification.sender.NotificationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class NotificationFactory {

    public static NotificationEntity create(SendNotificationCommand command, NotificationResult result) {
        return NotificationEntity.builder()
                .apartmentId(command.apartmentId())
                .name(command.name())
                .subject(command.subject())
                .phoneNumber(command.phoneNumber())
                .message(command.message())
                .type(command.type())
                .error(result.getError())
                .success(result.isSuccess())
                .build();
    }
}
