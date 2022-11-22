package com.apartments.domain.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface NotificationJpaRepository extends JpaRepository<NotificationEntity, Long> {

    @Query("select n from NotificationEntity n " +
            "where lower(n.subject) like lower(concat('%', :filterText, '%'))")
    List<NotificationEntity> search(String filterText);
}
