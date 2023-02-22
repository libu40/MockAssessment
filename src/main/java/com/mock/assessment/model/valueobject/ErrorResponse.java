package com.mock.assessment.model.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * this class is used to hold error related data for the application exceptions.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private String message;
    private LocalDateTime timeStamp;

    public ErrorResponse(int statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;

    }

}
