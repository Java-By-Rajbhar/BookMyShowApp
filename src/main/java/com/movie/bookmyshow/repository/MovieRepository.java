package com.movie.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.bookmyshow.entity.Movie;
/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	public List<Movie> findByMovieIdIn(List<Integer> movieId);

}
