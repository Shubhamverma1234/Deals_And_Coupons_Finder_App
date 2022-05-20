package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value="${data.exception.incmsg}")
	private String incmsg;
    @ExceptionHandler(value=Invalid_CredentialsException.class)
    public ResponseEntity<String>DataDoesNotExistException(Invalid_CredentialsException dae){
    	return new ResponseEntity<String>(incmsg,HttpStatus.CONFLICT);
    }
}
