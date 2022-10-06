package com.luxoft.boot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetails> notFoundHandler(ResourceNotFound ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "Resource not found!", new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
	
	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ErrorDetails>GenericException(GenericException ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "Resource not found!", new Date());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
}
	@ExceptionHandler(StudentEnrollmentNotFoundException.class)
	public ResponseEntity<ErrorDetails>StudentEnrollmentNotFoundException(StudentEnrollmentNotFoundException ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "Resource not found!", new Date());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	@ExceptionHandler(BlogAPIException.class)
	public ResponseEntity<ErrorDetails>BlogAPIException(BlogAPIException ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "Resource not found!", new Date());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handleGlobalException(Exception ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "Resource not found!", new Date());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

