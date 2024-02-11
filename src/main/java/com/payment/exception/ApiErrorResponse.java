package com.payment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {
    private final HttpStatus status;
    private final String message;
    private final Instant timestamp;

}
