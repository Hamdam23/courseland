package com.courseland.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotificationRequest {

    private Long receivingUserId;

    private String message;
}
