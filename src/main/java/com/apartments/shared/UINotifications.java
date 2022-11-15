package com.apartments.shared;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.stereotype.Component;

@Component
public class UINotifications {

    public static void success(String text) {
        Notification notification = new Notification();
        notification.setPosition(Notification.Position.MIDDLE);
        notification.setDuration(3 * 1000);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setText(text);
        notification.open();
    }

    public static void error(String text) {
        Notification notification = new Notification();
        notification.setPosition(Notification.Position.MIDDLE);
        notification.setDuration(5 * 1000);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.setText(text);
        notification.open();
    }
}
