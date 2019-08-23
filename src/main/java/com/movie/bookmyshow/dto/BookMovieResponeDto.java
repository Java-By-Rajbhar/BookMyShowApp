package com.movie.bookmyshow.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponeDto implements Serializable{

	private int statusCode;
	private String message;
}
