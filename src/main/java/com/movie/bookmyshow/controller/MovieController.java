package com.movie.bookmyshow.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmyshow.dto.MovieResponseDto;
import com.movie.bookmyshow.service.MovieService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class MovieController {
private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieService movieService;
	@GetMapping("/movies/{bookDate}")
	public ResponseEntity<List<MovieResponseDto>> getListMovie(@PathVariable String bookDate)
	{
		logger.info("inside getListMovie method of MovieController class");
		List<MovieResponseDto> movieResponse = movieService.getListMovieByBookDate(bookDate);
		
		return new ResponseEntity<List<MovieResponseDto>>(movieResponse, HttpStatus.OK);
	}
}
