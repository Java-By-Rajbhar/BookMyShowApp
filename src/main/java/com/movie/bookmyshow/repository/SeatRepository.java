package com.movie.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.bookmyshow.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {


	Seat findByTheatreId(Integer theatreId);


	public Seat findByTheatreId(int id);

}
