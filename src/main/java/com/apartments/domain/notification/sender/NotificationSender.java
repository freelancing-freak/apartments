package com.apartments.domain.notification.sender;

import com.apartments.domain.notification.NotificationType;
import com.apartments.domain.notification.command.SendNotificationCommand;

public interface NotificationSender {

    boolean isApplicableFor(NotificationType type);

    NotificationResult send(SendNotificationCommand command);
}
