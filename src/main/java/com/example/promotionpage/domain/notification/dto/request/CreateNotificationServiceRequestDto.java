package com.example.promotionpage.domain.notification.dto.request;

import com.example.promotionpage.domain.notification.domain.Notification;

public record CreateNotificationServiceRequestDto(
        Boolean isRead
) {
    public Notification toEntity() {
        return Notification.builder()
                .isRead(isRead)
                .build();
    }
}