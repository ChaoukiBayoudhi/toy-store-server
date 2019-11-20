package com.jee.tp.serveruser.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class fileNotFoundException extends RuntimeException {
    public fileNotFoundException(String message) {
        super(message);
    }

    public fileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
