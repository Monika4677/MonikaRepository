package com.luxoft.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericException extends RuntimeException{
	

}
