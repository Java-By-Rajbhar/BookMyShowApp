package com.movie.bookmyshow.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyMovieResponseDto {

	private String movieName;
	private String theatreName;
	private String bookDate;
	private String emailId;
	private double price;
	private int totalSeat;
}
