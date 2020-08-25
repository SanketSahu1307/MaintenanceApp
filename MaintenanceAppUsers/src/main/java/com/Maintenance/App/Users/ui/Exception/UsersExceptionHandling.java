package com.Maintenance.App.Users.ui.Exception;

import java.util.Date;

import javax.validation.OverridesAttribute;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;





@RestController
@ControllerAdvice
public class UsersExceptionHandling extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleusersException(Exception ex,WebRequest request){
		ExceptionModel usersExcept=new ExceptionModel(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(usersExcept,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UsersNotFoundException.class)
	public ResponseEntity<Object> usersNotFoundException(UsersNotFoundException ex,WebRequest request){
		ExceptionModel usersExcept=new ExceptionModel(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(usersExcept,HttpStatus.NOT_FOUND);
	}
	
	@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			ExceptionModel usersExcept = new ExceptionModel(new Date(), "Validation Failed",ex.getBindingResult().toString());
			return new ResponseEntity<Object>(usersExcept, HttpStatus.BAD_REQUEST);
		}

	
	
	

	
	
	
	
}
