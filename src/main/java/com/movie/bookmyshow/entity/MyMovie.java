package com.movie.bookmyshow.entity;

import java.util.Date;

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
public class MyMovie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	private Integer movieId;
	private Integer theatreId; 
	private Date bookDate;
	private String emailId;
	private Integer totalSeat;
	private Double price;

}
