package com.movie.bookmyshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.bookmyshow.entity.MovieTheatre;

@Repository
public interface MovieTheatreRepository extends JpaRepository<MovieTheatre, Integer> {
	
	//@Query("select movieId from MovieTheatre mt where mt.bookDate=:bookDate")
	public List<MovieTheatre>  findByBookDate(String bookDate);

}
