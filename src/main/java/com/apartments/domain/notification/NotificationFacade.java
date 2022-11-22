package com.apartments.domain.notification;

import com.apartments.domain.notification.command.SendNotificationCommand;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotificationFacade {

    private final NotificationService service;

    public void send(SendNotificationCommand command) {
        service.send(command);
    }

    public List<Notification> findAll(String filterText) {
        return service.findAll(filterText);
    }

    public void deleteById(long id) {
        service.deleteById(id);
    }
}
