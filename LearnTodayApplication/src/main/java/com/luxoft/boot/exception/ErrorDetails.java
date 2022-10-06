package com.luxoft.boot.exception;

import java.util.Date;

public class ErrorDetails {
String message;
String details;
Date errorOccured;

public ErrorDetails(String message, String details, Date errorOccured) {
	super();
	this.message = message;
	this.details = details;
	this.errorOccured = errorOccured;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public Date getErrorOccured() {
	return errorOccured;
}
public void setErrorOccured(Date errorOccured) {
	this.errorOccured = errorOccured;
}


}
