package com.movie.bookmyshow.service;

import com.movie.bookmyshow.dto.BookMovieResponeDto;
import com.movie.bookmyshow.dto.BookMyMovieDto;

public interface BookTicketService {

	public BookMovieResponeDto bookMovie(BookMyMovieDto bookMovieDto);
}
