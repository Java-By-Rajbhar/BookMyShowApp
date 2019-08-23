package com.movie.bookmyshow.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.bookmyshow.dto.TheatreResponseDto;
import com.movie.bookmyshow.entity.Movie;
import com.movie.bookmyshow.entity.Seat;
import com.movie.bookmyshow.entity.Theatre;
import com.movie.bookmyshow.service.TheatreService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TheatreControllerTest {

	@Mock
	TheatreService theatreService;

	@InjectMocks
	TheatreController theatreController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(theatreController).build();
	}

	@Test
	public void getAllTheatresTest() {

		
		Theatre theatre = new Theatre();
		theatre.setTheatreId(1);
		theatre.setTheatreName("Cinepolis");
		Movie movie=new Movie();
		movie.setMovieId(1);
		movie.setPrice(120);
		movie.setMovieName("Angel Has Fallen");
		
		Seat seat = new Seat();
		seat.setAvailableSeat(67);
		seat.setTotalSeat(100);
		
		TheatreResponseDto theatreResponseDto2 = new TheatreResponseDto();
		List<TheatreResponseDto> theatreList = new ArrayList<>();
		theatreResponseDto2.setAvaibleSeats(seat.getAvailableSeat());
		theatreResponseDto2.setMovieId(movie.getMovieId());
		theatreResponseDto2.setMovieName(movie.getMovieName());
		theatreResponseDto2.setPrice(movie.getPrice());
		theatreList.add(theatreResponseDto2);
		
		
		Mockito.when(theatreService.getAllTheatres(movie.getMovieId())).thenReturn(theatreList);
		ResponseEntity<List<TheatreResponseDto>> actual = theatreController.getAllTheatres(1);
		assertEquals(1,actual.getBody().size());

	}




	public  String asJsonString(final Object obj) {

		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

