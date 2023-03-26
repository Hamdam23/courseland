package com.courseland.commons.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorDetails {

    private HttpStatus status;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;

    public ErrorDetails(HttpStatus status, String message) {
        super();
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}
