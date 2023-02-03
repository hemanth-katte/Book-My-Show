package com.example.BookMyShow.Book.My.Show.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
public class MovieResponseDto {

    private int id;

    private String  movieName;

    private Date releaseDate;

    private List<Integer> showList;

}
