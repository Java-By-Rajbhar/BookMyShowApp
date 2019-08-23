package com.movie.bookmyshow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Seat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer seatId;
	private Integer theatreId;
	private Integer totalSeat;
	private Integer availableSeat;

}
