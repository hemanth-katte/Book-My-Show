package com.example.BookMyShow.Book.My.Show.RequestDto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class MovieRequestDto {

    private String movieName;
    private Date releaseDate;

}
