package com.apartments.domain.notification.sender;

import com.apartments.domain.notification.command.SendNotificationCommand;

public record NotificationSenderService(NotificationSenderFactory notificationSenderFactory) {

    public NotificationResult send(SendNotificationCommand command) {
        NotificationSender sender = notificationSenderFactory.getStrategyFor(command.type());
        return sender.send(command);
    }
}
