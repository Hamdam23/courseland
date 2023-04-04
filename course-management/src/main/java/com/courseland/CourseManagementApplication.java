package com.courseland;

import com.courseland.clients.file.FileServiceClient;
import com.courseland.clients.user.AppUserServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {FileServiceClient.class, AppUserServiceClient.class})
public class CourseManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseManagementApplication.class, args);
    }
}