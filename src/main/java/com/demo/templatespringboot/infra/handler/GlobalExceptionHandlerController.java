package com.demo.templatespringboot.infra.handler;

import com.demo.templatespringboot.api.exception.ApiError;
import com.demo.templatespringboot.api.exception.NoSuchElementFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<ApiError> handlerNotFoundException(NoSuchElementFoundException ex) {

        return new ResponseEntity<>(
                new ApiError(HttpStatus.NOT_FOUND, ex.getMessage()).getStatus());

    }
}
