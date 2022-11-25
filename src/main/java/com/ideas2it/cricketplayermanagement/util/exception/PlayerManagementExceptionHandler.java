package com.ideas2it.cricketplayermanagement.util.exception;

import com.ideas2it.cricketplayermanagement.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class PlayerManagementExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlayerManagementException.class)
    public ResponseEntity<ErrorMessage> notFoundException(PlayerManagementException playerManagementException) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, playerManagementException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
