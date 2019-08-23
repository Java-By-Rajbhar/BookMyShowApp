package com.movie.bookmyshow.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BookMyMovieDto implements Serializable{

	private int movieId;
	private int theatreId;
	private String bookDate;
	private String emailId;
	private double price;
	private int totalSeat;
	
}

