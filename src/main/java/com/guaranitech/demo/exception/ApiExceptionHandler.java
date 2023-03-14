package com.guaranitech.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ApiException handleBadRequestException(BadRequestException e) {
        return ApiException
                .builder()
                .errorMessage(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .zonedDateTime(ZonedDateTime.now())
                .build();
    }

    @ExceptionHandler(EntityCreateFailedException.class)
    @ResponseBody
    public ApiException handleEntityCreateFailedException(EntityCreateFailedException e) {
        return ApiException
                .builder()
                .errorMessage(e.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .zonedDateTime(ZonedDateTime.now())
                .build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ApiException handleEntityNotFoundException(EntityNotFoundException e) {
        return ApiException
                .builder()
                .errorMessage(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .zonedDateTime(ZonedDateTime.now())
                .build();
    }
}
