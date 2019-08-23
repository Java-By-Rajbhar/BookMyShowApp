package com.movie.bookmyshow.repository;

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

	Movie findByMovieId(int movieId);

}
