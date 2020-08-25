package com.Maintenance.App.Users.ui.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsersNotFoundException extends RuntimeException {
	
	public UsersNotFoundException(String message) {
		super(message);
	}

}
