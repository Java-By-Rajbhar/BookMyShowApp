package com.movie.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieResponseDto {
	
	private Integer movieId;
	private String movieName;
	private double price;
	private String restricted;
	private String viewLink;

}
