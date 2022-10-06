package com.luxoft.boot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetails> notFoundHandler(ResourceNotFound ex) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "Resource not found!", new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
}
