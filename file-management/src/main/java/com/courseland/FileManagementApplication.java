package com.courseland;

import com.courseland.file.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class FileManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileManagementApplication.class, args);
    }
}