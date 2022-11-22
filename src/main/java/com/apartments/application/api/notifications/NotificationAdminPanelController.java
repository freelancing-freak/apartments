package com.apartments.application.api.notifications;

import com.apartments.domain.notification.Notification;
import com.apartments.domain.notification.NotificationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin-panel/notifications")
@RequiredArgsConstructor
class NotificationAdminPanelController {

    private final NotificationFacade facade;

    @GetMapping
    public List<Notification> findAll(@RequestParam(value = "filter_text", required = false) String filterText) {
        return facade.findAll(filterText);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        facade.deleteById(id);
    }
}
