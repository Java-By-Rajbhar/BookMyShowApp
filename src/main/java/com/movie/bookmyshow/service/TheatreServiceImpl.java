package com.movie.bookmyshow.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int getAvailableSeatBasedOnThreatre(String theatreName) {
		logger.info("inside getAvailableSeatBasedOnThreatre method of TheatreServiceImpl class");
		Theatre theatre = theatreRepository.findByTheatreName(theatreName);
		return theatre.getAvailableSeat();
	}

}
