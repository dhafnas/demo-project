package com.dhafnas.featuremanage.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dhafnas.featuremanage.exception.model.ApiError;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
	  MethodArgumentTypeMismatchException ex, WebRequest request) {
	    String error = 
	      ex.getName() + " should be of type " + ex.getRequiredType().getName();
	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}
}
