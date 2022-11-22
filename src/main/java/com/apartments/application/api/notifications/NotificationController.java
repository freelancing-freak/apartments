package com.apartments.application.api.notifications;

import com.apartments.application.api.notifications.request.NotificationRequest;
import com.apartments.domain.notification.NotificationFacade;
import com.apartments.domain.notification.command.SendNotificationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/notifications")
@RequiredArgsConstructor
class NotificationController {

    private final NotificationFacade facade;

    @PostMapping
    public void send(@Valid @RequestBody NotificationRequest request) {
        facade.send(SendNotificationCommand.email(request));
    }
}
