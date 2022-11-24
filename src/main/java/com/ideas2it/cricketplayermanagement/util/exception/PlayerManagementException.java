package com.ideas2it.cricketplayermanagement.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlayerManagementException extends Exception {
	public PlayerManagementException(String message) {
		super(message);
	}
}