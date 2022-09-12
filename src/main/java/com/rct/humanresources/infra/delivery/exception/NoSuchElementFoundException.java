package com.rct.humanresources.infra.delivery.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * NoSuchElementFoundException
 * return HttpStatus 404
 */
@ResponseStatus(value = NOT_FOUND)
public class NoSuchElementFoundException extends ResponseStatusException {
    public NoSuchElementFoundException() {
        super(NOT_FOUND);
    }

}
