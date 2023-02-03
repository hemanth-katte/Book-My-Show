package com.example.BookMyShow.Book.My.Show.Service;

import com.example.BookMyShow.Book.My.Show.Models.*;
import com.example.BookMyShow.Book.My.Show.Repository.MovieRepository;
import com.example.BookMyShow.Book.My.Show.Repository.ShowRepository;
import com.example.BookMyShow.Book.My.Show.Repository.ShowSeatRepository;
import com.example.BookMyShow.Book.My.Show.Repository.TheaterRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.ShowRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;

    public String createShow(ShowRequestDto showRequestDto){

        Show show = Show.builder().showDate(showRequestDto.getShowDate()).showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();

        Movie movie = movieRepository.findById(showRequestDto.getMovieId()).get();

        Theater theater = theaterRepository.findById(showRequestDto.getTheaterId()).get();

        show.setMovie(movie);
        show.setTheater(theater);

        movie.getListOfShows().add(show);
        theater.getListOfShows().add(show);

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = createShowSeats(theaterSeatList);

        show.setShowSeatList(showSeatList);

        for(ShowSeat showSeat : showSeatList)
            showSeat.setShow(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been successfully added";

    }

    private List<ShowSeat> createShowSeats(List<TheaterSeat> theaterSeatList){

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeat showSeat = ShowSeat.builder().seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).build();
            showSeatList.add(showSeat);
        }
        showSeatRepository.saveAll(showSeatList);

        return showSeatList;

    }
}
