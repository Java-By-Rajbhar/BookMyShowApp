package com.movie.bookmyshow.service;

import java.util.List;

import com.movie.bookmyshow.dto.MovieResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface MovieService {
	
	public List<MovieResponseDto> getListMovieByBookDate(String  bookDate);

}
