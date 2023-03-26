package com.courseland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.courseland.file",
                "com.courseland.commons"
        }
)
public class FileManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileManagementApplication.class, args);
    }
}