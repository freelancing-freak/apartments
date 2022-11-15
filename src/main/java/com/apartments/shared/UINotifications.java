package com.apartments.shared;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.stereotype.Component;

@Component
public class UINotifications {

    private static final int THREE_SECONDS = 3 * 1000;

    private final Notification notification;

    private UINotifications() {
        notification = new Notification();
        notification.setPosition(Notification.Position.MIDDLE);
        notification.setDuration(THREE_SECONDS);
    }

    public void success(String text) {
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setText(text);
        notification.open();
    }

    public void error(String text) {
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.setText(text);
        notification.open();
    }
}
