package com.example.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class ExceptionResponseDto {
    private String apiPath;
    private HttpStatus statusCode;
    private String errorMessage;

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(LocalDateTime errorTime) {
        this.errorTime = errorTime;
    }

    private LocalDateTime errorTime;

    public ExceptionResponseDto(String apiPath, HttpStatus statusCode, String errorMessage, LocalDateTime errorTime){
        this.apiPath = apiPath;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }
}
