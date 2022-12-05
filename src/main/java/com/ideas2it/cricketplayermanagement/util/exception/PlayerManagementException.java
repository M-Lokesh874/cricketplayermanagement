package com.ideas2it.cricketplayermanagement.util.exception;

import org.springframework.http.HttpStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlayerManagementException extends Exception {
    private HttpStatus status;

    public PlayerManagementException(String message) {
        super(message);
    }

    public PlayerManagementException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}