package com.example.BookMyShow.Book.My.Show.Converters;

import com.example.BookMyShow.Book.My.Show.Models.Theater;
import com.example.BookMyShow.Book.My.Show.RequestDto.TheaterRequestDto;

public class TheaterConvertor {

    public static Theater convertTheaterRequestDtoToTheater(TheaterRequestDto theaterRequestDto){

        Theater theater = Theater.builder().name(theaterRequestDto.getName()).city(theaterRequestDto.getCity()).address(theaterRequestDto.getAddress()).build();

        return theater;
    }
}
