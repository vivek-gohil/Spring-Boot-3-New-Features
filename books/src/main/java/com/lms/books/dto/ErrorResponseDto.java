package com.lms.books.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Lombok annotation to generate getter and setter methods
@AllArgsConstructor // Lombok annotation to generate all argument constructor
public class ErrorResponseDto {
    private String apiPath;
    private HttpStatus httpStatus;
    private String errorMessage;
    private LocalDateTime errorTime;
}
