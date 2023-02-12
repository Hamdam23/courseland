package com.courseland.file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.unit.DataSize;

@ConfigurationProperties(value = "multipart")
@Getter
@Setter
public class FileStorageProperties {

    private DataSize maxFileSize;
}
