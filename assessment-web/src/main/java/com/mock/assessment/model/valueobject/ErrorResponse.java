package com.mock.assessment.model.valueobject;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
