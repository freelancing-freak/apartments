package com.apartments.domain.notification.sender;

import com.apartments.domain.notification.NotificationType;

import java.util.List;

public record NotificationSenderFactory(List<NotificationSender> notificationSenders) {

    public NotificationSender getStrategyFor(NotificationType notificationType) {
        return notificationSenders.stream()
                .filter(strategy -> strategy.isApplicableFor(notificationType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid notificationType for notification sender"));
    }
}
