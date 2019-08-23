package com.movie.bookmyshow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.bookmyshow.dto.BookMovieResponeDto;
import com.movie.bookmyshow.dto.BookMyMovieDto;
import com.movie.bookmyshow.entity.Movie;
import com.movie.bookmyshow.entity.MyMovie;
import com.movie.bookmyshow.entity.Seat;
import com.movie.bookmyshow.entity.Theatre;
import com.movie.bookmyshow.repository.MovieRepository;
import com.movie.bookmyshow.repository.MyMovieRepository;
import com.movie.bookmyshow.repository.SeatRepository;
import com.movie.bookmyshow.repository.TheatreRepository;

@Service
public class BookTicketServiceImpl implements BookTicketService {
 
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired
	private MyMovieRepository myMovieRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
    MailService mailservice;
	
	@Override
	public BookMovieResponeDto bookMovie(BookMyMovieDto bookMovieDto) {

		Optional<Movie> movieRepo=movieRepository.findById(bookMovieDto.getMovieId());
		Movie movie =new Movie();
		if(movieRepo.isPresent())
		{
			movie=movieRepo.get();
		}
		Optional<Theatre> threaterRepo=theatreRepository.findById(bookMovieDto.getTheatreId());
		Theatre theatre =new Theatre();
		if(movieRepo.isPresent())
		{
			theatre=threaterRepo.get();
		}
		MyMovie myMovie=new MyMovie();
		Seat seat=seatRepository.findByTheatreId(bookMovieDto.getTheatreId());
		BookMovieResponeDto bookMovieResponeDto=new BookMovieResponeDto();
		
		if(bookMovieDto.getTotalSeat()<3)
		{
			if(seat.getAvailableSeat()>0)
			{
				if(seat.getAvailableSeat()>bookMovieDto.getTotalSeat())
				{
					
					
				
				myMovie.setBookDate(bookMovieDto.getBookDate());
				myMovie.setEmailId(bookMovieDto.getEmailId());
				myMovie.setMovieId(bookMovieDto.getMovieId());
				myMovie.setPrice(bookMovieDto.getPrice());
				myMovie.setTheatreId(bookMovieDto.getTheatreId());
				myMovie.setTotalSeat(bookMovieDto.getTotalSeat());
				myMovieRepository.save(myMovie);
				
				int updatedSeat=seat.getAvailableSeat()-bookMovieDto.getTotalSeat();
				seat.setAvailableSeat(updatedSeat);
				seatRepository.save(seat);
				bookMovieResponeDto.setMessage("movie booked");
				bookMovieResponeDto.setStatusCode(200);	
				mailservice.sendEmails(bookMovieDto.getEmailId(), bookMovieDto.getTotalSeat()+" tickets booked  for you.  "+movie.getMovieName()+" at "+theatre.getTheatreName()+"  for Rs."+bookMovieDto.getPrice());
			
			  }
				else
				{
					bookMovieResponeDto.setMessage("no seat available");
					bookMovieResponeDto.setStatusCode(400);	
				}
			}
			else
			{
				bookMovieResponeDto.setMessage("no seat available");
				bookMovieResponeDto.setStatusCode(400);	
			}
		
			
		}
		else
		{
			bookMovieResponeDto.setMessage("Max 3 tickets only");
			bookMovieResponeDto.setStatusCode(400);	
		}
		
		
		return bookMovieResponeDto;
	}

}
