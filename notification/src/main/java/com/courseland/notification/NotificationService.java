package com.courseland.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRaepository notificationRaepository;

    public void send(NotificationRequest request) {
        notificationRaepository.save(
                Notification.builder()
                        .receivingUserId(request.getReceivingUserId())
                        .message(request.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}