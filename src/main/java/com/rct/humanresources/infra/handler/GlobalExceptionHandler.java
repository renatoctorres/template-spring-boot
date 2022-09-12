package com.rct.humanresources.infra.handler;

import com.rct.humanresources.infra.delivery.exception.NoSuchElementFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * GlobalExceptionHandler - Handler all exceptions in Application
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handler NoSuchElementFoundException
     * @param ex NoSuchElementFoundException
     * @return ResponseEntity
     */
    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<String> handlerNotFoundException(NoSuchElementFoundException ex) {
        return ResponseEntity.status(NOT_FOUND).body(ex.getMessage());
    }
}
