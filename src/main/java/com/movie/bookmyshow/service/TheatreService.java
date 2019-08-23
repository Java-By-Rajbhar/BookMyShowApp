package com.movie.bookmyshow.service;

import java.util.List;

import com.movie.bookmyshow.dto.TheatreResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface TheatreService {
	


	public List<TheatreResponseDto> getAllTheatres(int movieId);

}
