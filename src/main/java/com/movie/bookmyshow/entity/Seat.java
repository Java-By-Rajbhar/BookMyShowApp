package com.movie.bookmyshow.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
	
	private Integer seatId;
	@OneToOne(mappedBy="theatreId")
	private Theatre theatre;
	private Integer totalSeat;
	private Integer availableSeat;

}
