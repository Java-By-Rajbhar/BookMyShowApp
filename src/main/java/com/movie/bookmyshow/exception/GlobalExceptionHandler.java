package com.movie.bookmyshow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Sushil
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * This method is use to handle exception globally
	 * 
	 * @param ex
	 * @return ResponseEntity<ResponseError>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseError> exceptionHandler(Exception ex) {
		ResponseError error = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TheatresNotFoundException.class)
	private ResponseEntity<ResponseError> TheatreNothandlerExceptions(TheatresNotFoundException ex) {
		ResponseError errorResponse = new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
