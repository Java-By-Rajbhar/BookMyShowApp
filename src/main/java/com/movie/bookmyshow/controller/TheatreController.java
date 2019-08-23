package com.movie.bookmyshow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmyshow.service.TheatreService;

@RequestMapping("/api")
@RestController
public class TheatreController {
	
	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);
	@Autowired
	TheatreService theatreService;
	@GetMapping("/availableSeat/{theatreName}")
	public ResponseEntity<Integer> getAvailableSeat(@PathVariable String theatreName)
	{
		logger.info("inside getAvailableSeat method of TheatreController class");
       int availableSeat = theatreService.getAvailableSeatBasedOnThreatre(theatreName);
       return new ResponseEntity<Integer>(availableSeat, HttpStatus.OK);
	}

}
