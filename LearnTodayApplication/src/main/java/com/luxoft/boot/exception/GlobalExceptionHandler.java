package com.luxoft.boot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
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
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "GenericException!", new Date());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
}
	@ExceptionHandler(StudentEnrollmentNotFoundException.class)
	public ResponseEntity<ErrorDetails>StudentEnrollmentNotFoundException(StudentEnrollmentNotFoundException ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "StudentEnrollmentNotFoundException!", new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorDetails>BlogAPIException(ApiException ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "ApiException!", new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<ErrorDetails>badReqException(BadRequest ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "BadRequest", new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handleGlobalException(Exception ex,WebRequest webRequest) {
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "Exception!", new Date());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

