package com.movie.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.bookmyshow.dto.MovieResponseDto;
import com.movie.bookmyshow.entity.Movie;
import com.movie.bookmyshow.entity.MovieTheatre;
import com.movie.bookmyshow.exception.NoMovieAvailableException;
import com.movie.bookmyshow.repository.MovieRepository;
import com.movie.bookmyshow.repository.MovieTheatreRepository;
/**
 * 
 * @author Sushil
 *
 */
@Service
public class MovieServiceImpl implements MovieService {
	private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	@Autowired
	MovieTheatreRepository movieTheatreRepository;
	
	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<MovieResponseDto> getListMovieByBookDate(String bookDate) {
	logger.info("inside getListMovieByBookDate method of MovieServiceImpl class");
	//create list of movie id
			List<Integer> movieIdList = new ArrayList<>();
		//get movieId based on book date
	
	logger.info("bookDate ={}",bookDate);
		List<MovieTheatre>	movieTheatre = movieTheatreRepository.findByBookDate(bookDate);
		logger.info("movieTheatre size ={}",movieTheatre.size());
		for (MovieTheatre movieTheatre2 : movieTheatre) {
			movieIdList.add(movieTheatre2.getMovieId());
		}
		logger.info("movieTheatre object ={}",movieTheatre);
		logger.info("movieIdList object ={}",movieIdList);
		logger.info("movieIdList object size ={}",movieIdList.size());
		
		if(movieTheatre!=null)
		{
			 List<Movie> movies = movieRepository.findByMovieIdIn(movieIdList);
			 List<MovieResponseDto> response = new ArrayList<MovieResponseDto>();
			 for (Movie movie : movies) {
				 MovieResponseDto responseDto =  new MovieResponseDto();
				 responseDto.setMovieId(movie.getMovieId());
				 responseDto.setMovieName(movie.getMovieName());
				 responseDto.setPrice(movie.getPrice());
				 responseDto.setRestricted(movie.getRestricted());
				 responseDto.setViewLink(movie.getViewLink());
				 
				 response.add(responseDto);
				 
				 
				 
			}
			 return response;
		}
		else
		{
			throw new NoMovieAvailableException("No Movie available");
		}
	}


	
	

}
