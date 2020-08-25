package com.Maintenance.App.Notices.ui.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoticeNotFoundException extends RuntimeException{

	public NoticeNotFoundException(String message) {
		super(message);
	}

}
