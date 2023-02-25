package com.courseland.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRaepository extends JpaRepository<Notification, Long> {
}