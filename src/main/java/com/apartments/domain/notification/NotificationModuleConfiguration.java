package com.apartments.domain.notification;

import com.apartments.domain.notification.sender.NotificationSender;
import com.apartments.domain.notification.sender.NotificationSenderFactory;
import com.apartments.domain.notification.sender.NotificationSenderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class NotificationModuleConfiguration {

    @Bean
    public NotificationFacade notificationFacade(NotificationJpaRepository jpaRepository,
                                                 List<NotificationSender> notificationSenders) {
        NotificationSenderFactory notificationSenderFactory = new NotificationSenderFactory(notificationSenders);
        NotificationSenderService notificationSenderService = new NotificationSenderService(notificationSenderFactory);
        NotificationService service = new NotificationService(jpaRepository, notificationSenderService);
        return new NotificationFacade(service);
    }
}
