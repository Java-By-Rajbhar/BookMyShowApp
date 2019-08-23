/**
 * 
 */
package com.movie.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.bookmyshow.entity.Theatre;

/**
 * @author Sushil
 *
 */
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
	
	public Theatre findByTheatreName(String theatreName);

}
