package com.movie.bookmyshow.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.bookmyshow.dto.TheatreResponseDto;
import com.movie.bookmyshow.entity.Theatre;
import com.movie.bookmyshow.repository.TheatreRepository;

/**
 * 
 * @author Sushil
 *
 */
@Service
public class TheatreServiceImpl implements TheatreService {
	
private static final Logger logger  = LoggerFactory.getLogger(TheatreServiceImpl.class);
    @Autowired
    TheatreRepository theatreRepository;
    /**
     * This method is use get available seat
     * @param theatreName
     * @return availableSeat
     */

	@Override
	public List<TheatreResponseDto> getAllTheatres(String movieId) {
		
		Movie movie = movieRepository.findByMovieId(movieId);
		Theatre theatre = theatreRepository.findAll();
		
		
		return null;
	}

}
