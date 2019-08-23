package com.movie.bookmyshow.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.bookmyshow.dto.BookMovieResponeDto;
import com.movie.bookmyshow.dto.BookMyMovieDto;
import com.movie.bookmyshow.service.BookTicketServiceImpl;


@RunWith(SpringRunner.class)
public class BookTicketControllerTest {

	
	private MockMvc mockMvc;
	
	@Mock
	BookTicketServiceImpl bookTicketServiceImpl;
	
	
	@MockBean
	BookTicketController bookTicketController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookTicketController).build();
	}
	
	
	@Test
	public void testBookTicket() throws Exception {

		BookMyMovieDto bookMyMovieDto = new BookMyMovieDto();
		bookMyMovieDto.setEmailId("shashankkumar0155@gmail.com");
		bookMyMovieDto.setMovieId(1);
		bookMyMovieDto.setPrice(500);
		bookMyMovieDto.setTheatreId(1);
		bookMyMovieDto.setTotalSeat(2);
		bookMyMovieDto.setBookDate("2019-09-23");

		
		
		mockMvc.perform(post("/api/book").contentType(MediaType.APPLICATION_JSON).content(asJsonString(bookMyMovieDto))).andExpect(status().isOk());
	    
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
