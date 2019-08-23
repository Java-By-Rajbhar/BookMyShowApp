package com.movie.bookmyshow.dto;

import lombok.Data;

@Data
public class TheatreResponseDto {
	private int theatreId;
	private String theatreName;
	private String movieName;
	private int movieId;
	private double price;
	private String restriction;
	private int totalSeat;
	private int avaibleSeats;

}
