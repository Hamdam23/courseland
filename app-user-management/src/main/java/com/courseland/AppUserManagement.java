package com.courseland;

import com.courseland.clients.file.FileServiceClient;
import com.courseland.clients.notification.NotificationServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.courseland.user",
                "com.courseland.amqp"
        }
)
@EnableFeignClients(
        basePackageClasses = {
                FileServiceClient.class,
                NotificationServiceClient.class
        }
)
public class AppUserManagement {
    public static void main(String[] args) {
        SpringApplication.run(AppUserManagement.class, args);
    }
}