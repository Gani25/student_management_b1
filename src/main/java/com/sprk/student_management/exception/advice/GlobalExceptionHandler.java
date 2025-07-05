package com.sprk.student_management.exception.advice;

import com.sprk.student_management.dto.ErrorResponseDto;
import com.sprk.student_management.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentTypeMismatchException(StudentException e, WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(e.getMessage());
        errorResponseDto.setApiPath(request.getDescription(false));
        errorResponseDto.setHttpStatus(e.getStatus());
        errorResponseDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(e.getStatus()).body(errorResponseDto);
    }
}
