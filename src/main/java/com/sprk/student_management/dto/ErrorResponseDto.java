package com.sprk.student_management.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDto {

    private String apiPath;

    private HttpStatus httpStatus;

    private String message;

    private LocalDateTime timestamp;
}
