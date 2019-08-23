package com.movie.bookmyshow.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movie.bookmyshow.dto.BookMovieResponeDto;
import com.movie.bookmyshow.dto.BookMyMovieDto;
import com.movie.bookmyshow.entity.Movie;
import com.movie.bookmyshow.entity.Theatre;
import com.movie.bookmyshow.repository.MovieRepository;
import com.movie.bookmyshow.repository.MyMovieRepository;
import com.movie.bookmyshow.repository.SeatRepository;
import com.movie.bookmyshow.repository.TheatreRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookTicketServiceImplTest {

	@Mock
	MovieRepository movieRepository;
	
	@Mock
	TheatreRepository theatreRepository;
	
	@Mock
    MyMovieRepository myMovieRepository;
	
	@Mock
	SeatRepository seatRepository;
	
	@Mock
    MailService mailservice;
	
	@InjectMocks
	BookTicketServiceImpl bookTicketServiceImpl;
	
	
	@Test
	public void testBookMovie() {

		Movie movie=new Movie();
		movie.setMovieId(1);
		movie.setMovieName("AVENGER");
		movie.setPrice(500.00);
		movie.setRestricted("UA");
		movie.setViewLink("ok");
		Optional<Movie> movieOptional=Optional.of(movie);
		Theatre theatre=new Theatre();
		theatre.setTheatreId(1);
		theatre.setTheatreName("FORUM PVR");
		Optional<Theatre> theatreOptional=Optional.of(theatre);
		
		BookMovieResponeDto bookMovieResponeDto=new BookMovieResponeDto();
		
		BookMyMovieDto bookMyMovieDto=new BookMyMovieDto();
		bookMyMovieDto.setBookDate("");
		bookMyMovieDto.setEmailId("shashankkumar0155@gmail.com");
		bookMyMovieDto.setMovieId(1);
		bookMyMovieDto.setPrice(500);
		bookMyMovieDto.setTheatreId(1);
		bookMyMovieDto.setTotalSeat(3);
		
				
		when(movieRepository.findById(Mockito.anyInt())).thenReturn(movieOptional);
		when(theatreRepository.findById(Mockito.anyInt())).thenReturn(theatreOptional);
		BookMovieResponeDto bookMovieResponeDtoactual=bookTicketServiceImpl.bookMovie(bookMyMovieDto);
		assertEquals(400, bookMovieResponeDtoactual.getStatusCode());
	}

}
