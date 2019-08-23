package com.movie.bookmyshow.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
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
	
	private Integer ticketId;
	private Integer movieId;
	private Integer theatreId; 
	private LocalDate bookDate;
	private String emailId;

}
