package com.apartments.domain.notification;

import com.apartments.domain.apartments.Apartment;
import com.apartments.shared.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "notification", schema = "public")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class NotificationEntity extends BaseEntity {

    private Long apartmentId;
    private String name;
    private String subject;
    private String phoneNumber;
    private String message;
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    private String error;
    private boolean success;

    public Notification from() {
        Notification notification = new Notification();
        notification.setId(this.getId());
        notification.setCreatedDate(this.getCreatedDate().toLocalDate().toString());
        notification.setApartmentId(this.apartmentId);
        notification.setName(this.name);
        notification.setSubject(this.subject);
        notification.setPhoneNumber(this.phoneNumber);
        notification.setMessage(this.message);
        notification.setType(this.type.name());
        notification.setError(this.error);
        notification.setSuccess(this.success);
        return notification;
    }
}
