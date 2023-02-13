package com.courseland;

import com.courseland.clients.file.FileServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = FileServiceClient.class)
public class AppUserManagement {
    public static void main(String[] args) {
        SpringApplication.run(AppUserManagement.class, args);
    }
}