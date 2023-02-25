package com.courseland.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification")
public interface NotificationServiceClient {

    @PostMapping("api/v1/notifications/send")
    ResponseEntity<Void> send(@RequestBody NotificationRequest notificationRequest);
}
