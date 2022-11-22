package com.apartments.domain.notification;

import com.apartments.domain.notification.command.SendNotificationCommand;
import com.apartments.domain.notification.sender.NotificationResult;
import com.apartments.domain.notification.sender.NotificationSenderService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class NotificationService {

    private final NotificationJpaRepository repository;
    private final NotificationSenderService notificationSenderService;

    private final ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void send(SendNotificationCommand command) {
        executorService.submit(() -> {
            NotificationResult result = notificationSenderService.send(command);
            repository.save(NotificationFactory.create(command, result));
        });
    }

    public List<Notification> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return repository.findAll()
                    .stream()
                    .map(NotificationEntity::from)
                    .sorted(Comparator.comparing(Notification::getId))
                    .toList();
        }
        return repository.search(filterText)
                .stream()
                .map(NotificationEntity::from)
                .sorted(Comparator.comparing(Notification::getId))
                .toList();
    }

    @Transactional
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
