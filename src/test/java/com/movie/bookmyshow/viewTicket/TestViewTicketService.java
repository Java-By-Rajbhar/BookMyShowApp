package com.movie.bookmyshow.viewTicket;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.movie.bookmyshow.dto.MyMovieResponseDto;
import com.movie.bookmyshow.entity.Movie;
import com.movie.bookmyshow.entity.MyMovie;
import com.movie.bookmyshow.entity.Theatre;
import com.movie.bookmyshow.repository.MovieRepository;
import com.movie.bookmyshow.repository.MyMovieRepository;
import com.movie.bookmyshow.repository.TheatreRepository;
import com.movie.bookmyshow.service.BookTicketServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestViewTicketService {

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private TheatreRepository theatreRepository;

	@Mock
	private MyMovieRepository myMovieRepository;
	
	@InjectMocks
	private BookTicketServiceImpl bookTicketServiceImpl;
	
	List<MyMovieResponseDto> myMovieResponseDtoList = new ArrayList<>();
	List<Movie> movies = new ArrayList<>(); 
	List<Theatre> theatres =  new ArrayList<>(); 
	List<MyMovie> myMovies = new ArrayList<>();
	
	@Before
	void setup() {
		MyMovieResponseDto myMovieResponseDto = new MyMovieResponseDto();
		myMovieResponseDto.setMovieName("Don Mangal");
		myMovieResponseDto.setTheatreName("PVR Forum");
		myMovieResponseDto.setTotalSeat(20);
		myMovieResponseDto.setPrice(3456);
		myMovieResponseDto.setBookDate("2019-09-23");
		myMovieResponseDto.setEmailId("laxman@gmail.com");
		myMovieResponseDtoList.add(myMovieResponseDto);
		
		Movie movie= new Movie(101, "Don Mangal", 340, "UA", "Hello-hera-lal");
		movies.add(movie);
		
		Theatre theatre = new Theatre(1001, "PVR Forum");
		theatres.add(theatre);
		
		MyMovie myMovie =new MyMovie(101, 101, 1001, "2019-09-23", "laxman@gmaol.com", 20, 3456.0);
		myMovies.add(myMovie);
	}
	
	@Test
	public void testGetBookedTicket() {
		
		Mockito.when(movieRepository.findAll()).thenReturn(movies);
		Mockito.when(theatreRepository.findAll()).thenReturn(theatres);
		Mockito.when(myMovieRepository.findAll()).thenReturn(myMovies);
		
		List<MyMovieResponseDto> axpectedResult = bookTicketServiceImpl.getBookedMovies();
		
		assertEquals("Don Mangal", axpectedResult.get(0).getMovieName());
	}
}
