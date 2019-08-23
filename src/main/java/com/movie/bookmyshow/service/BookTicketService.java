package com.movie.bookmyshow.service;

import java.util.List;

import com.movie.bookmyshow.dto.BookMovieResponeDto;
import com.movie.bookmyshow.dto.BookMyMovieDto;
import com.movie.bookmyshow.dto.MyMovieResponseDto;

public interface BookTicketService {

	public BookMovieResponeDto bookMovie(BookMyMovieDto bookMovieDto);

	public List<MyMovieResponseDto> getBookedMovies();
}
