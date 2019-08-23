package com.movie.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.bookmyshow.entity.MyMovie;

public interface MyMovieRepository extends JpaRepository<MyMovie, Integer> {

}
