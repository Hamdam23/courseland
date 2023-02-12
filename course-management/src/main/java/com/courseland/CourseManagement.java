package com.courseland;

import com.courseland.file.FileServiceClient;
import com.courseland.user.AppUserServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackageClasses = {FileServiceClient.class, AppUserServiceClient.class}
)
public class CourseManagement {
    public static void main(String[] args) {
        SpringApplication.run(CourseManagement.class, args);
    }
}