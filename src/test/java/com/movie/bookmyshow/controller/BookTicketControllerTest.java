package com.movie.bookmyshow.controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.bookmyshow.dto.BookMovieResponeDto;
import com.movie.bookmyshow.dto.BookMyMovieDto;
import com.movie.bookmyshow.service.BookTicketServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BookTicketController.class)
public class BookTicketControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	BookTicketServiceImpl bookTicketServiceImpl;
	
	BookMyMovieDto bookMyMovieDto;
	
	@MockBean
	BookTicketController bookTicketController;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookTicketController).build();
	}
	
	
	@Test
	public void testBookTicket() throws Exception {

		BookMyMovieDto bookMyMovieDto=new BookMyMovieDto();
		bookMyMovieDto.setBookDate("");
		bookMyMovieDto.setEmailId("shashankkumar0155@gmail.com");
		bookMyMovieDto.setMovieId(1);
		bookMyMovieDto.setPrice(500);
		bookMyMovieDto.setTheatreId(1);
		bookMyMovieDto.setTotalSeat(3);
		BookMovieResponeDto bookMovieResponeDto=new BookMovieResponeDto();
		bookMovieResponeDto.setMessage("movie booked");
		bookMovieResponeDto.setStatusCode(200);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/book").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString("bookMyMovieDto"))).andExpect(MockMvcResultMatchers.status().isCreated());
		
		Mockito.when(bookTicketServiceImpl.bookMovie(Mockito.any())).thenReturn(bookMovieResponeDto);
		ResponseEntity<BookMovieResponeDto> actual=bookTicketController.bookTicket(bookMyMovieDto);
		assertEquals(400, actual.getBody().getMessage());
	
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
