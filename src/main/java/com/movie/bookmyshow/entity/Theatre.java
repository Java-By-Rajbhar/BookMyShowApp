package com.movie.bookmyshow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
@Entity
@Table
public class Theatre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long theatreId;
	private String theatreName;

}
