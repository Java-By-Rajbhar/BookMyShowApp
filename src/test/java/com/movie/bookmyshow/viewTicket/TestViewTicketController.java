package com.movie.bookmyshow.viewTicket;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.movie.bookmyshow.controller.BookTicketController;
import com.movie.bookmyshow.service.BookTicketServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestViewTicketController {

	@Mock
	private BookTicketServiceImpl bookTicketServiceImpl;
	
	@InjectMocks
	private BookTicketController bookTicketController;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookTicketController).build();
	}
	
	@Test
	public void testGetBookedTicket() throws Exception {
		mockMvc.perform(get("/api/viewTicket").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
