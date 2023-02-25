package com.courseland;

import com.courseland.file.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileProperties.class)
public class FileManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileManagementApplication.class, args);
    }
}