package com.movie.bookmyshow.exception;

public class NoMovieAvailableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoMovieAvailableException(String message)
	{
		super(message);
	}

}
