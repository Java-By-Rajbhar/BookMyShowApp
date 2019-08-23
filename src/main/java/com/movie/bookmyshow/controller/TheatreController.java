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

import com.movie.bookmyshow.dto.TheatreResponseDto;
import com.movie.bookmyshow.service.TheatreService;

@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class TheatreController {
	
	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);
	@Autowired
	TheatreService theatreService;

	
	@GetMapping("/theatres/{movieId}")
	public ResponseEntity<List<TheatreResponseDto>>getAllTheatres(@PathVariable int movieId)
	{
		logger.info("inside getAvailableSeat method of TheatreController class");
      List<TheatreResponseDto> listOfTheatres = theatreService.getAllTheatres(movieId);
       return new ResponseEntity<List<TheatreResponseDto>>(listOfTheatres, HttpStatus.OK);
	}
	
	

}
