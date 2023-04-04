package com.courseland.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRaepository notificationRaepository;

    public void send(NotificationRequest request) {
        log.info("Saving new Notification request {}", request);
        notificationRaepository.save(
                Notification.builder()
                        .receivingUserId(request.getReceivingUserId())
                        .message(request.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}