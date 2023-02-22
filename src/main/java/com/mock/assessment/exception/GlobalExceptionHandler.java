package com.mock.assessment.exception;

import com.mock.assessment.model.valueobject.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.ws.rs.*;

/**
 * this class is used to handle exception globally in the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BadRequestException.class, ClientErrorException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleClientException(Exception ex) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorResponse
    handleForbiddenException(Exception ex) {
        return new ErrorResponse(
                HttpStatus.FORBIDDEN.value(), ex.getMessage());
    }

    @ExceptionHandler({InternalServerErrorException.class, ServerErrorException.class, ServiceUnavailableException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse
    handleServerException(Exception ex) {
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse
    handleNotFoundException(Exception ex) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}

