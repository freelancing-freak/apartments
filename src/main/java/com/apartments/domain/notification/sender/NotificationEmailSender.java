package com.apartments.domain.notification.sender;

import com.apartments.domain.notification.NotificationType;
import com.apartments.domain.notification.command.SendNotificationCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile(value = {"beta", "prod"})
class NotificationEmailSender implements NotificationSender {

    private static final NotificationType NOTIFICATION_EMAIL_TYPE = NotificationType.EMAIL;

    @Override
    public boolean isApplicableFor(NotificationType type) {
        return NOTIFICATION_EMAIL_TYPE == type;
    }

    @Override
    public NotificationResult send(SendNotificationCommand command) {
        try {
            return NotificationResult.success();
        } catch (Exception e) {
            return NotificationResult.error(e.getMessage());
        }
    }
}
