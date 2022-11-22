package com.apartments.domain.notification.sender;

import com.apartments.domain.notification.NotificationType;
import com.apartments.domain.notification.command.SendNotificationCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile(value = "local")
public class NotificationMockSender implements NotificationSender {

    @Override
    public boolean isApplicableFor(NotificationType type) {
        return true;
    }

    @Override
    public NotificationResult send(SendNotificationCommand command) {
        log.info("Notification sender is mocked for local env: {}", command);
        return NotificationResult.success();
    }
}
