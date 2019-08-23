package com.movie.bookmyshow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmyshow.dto.BookMovieResponeDto;
import com.movie.bookmyshow.dto.BookMyMovieDto;
import com.movie.bookmyshow.service.BookTicketService;

@RestController
@RequestMapping("/api")

@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })

public class BookTicketController {

	@Autowired
	private BookTicketService bookTicketService;
	
	public static final Logger logger = LoggerFactory.getLogger(BookTicketController.class);
	
	@PostMapping("/book")
	public ResponseEntity<BookMovieResponeDto> bookTicket(@RequestBody BookMyMovieDto bookMyMovieDto)
	{
		logger.info("in bookTicket controller");
		
		return new ResponseEntity<>(bookTicketService.bookMovie(bookMyMovieDto),HttpStatus.OK);
	}
	
}
