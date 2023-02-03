package com.example.BookMyShow.Book.My.Show.Converters;

import com.example.BookMyShow.Book.My.Show.Models.Movie;
import com.example.BookMyShow.Book.My.Show.Models.Show;
import com.example.BookMyShow.Book.My.Show.RequestDto.MovieRequestDto;
import com.example.BookMyShow.Book.My.Show.ResponseDto.MovieResponseDto;

import java.util.ArrayList;
import java.util.List;

public class MovieConvertor {

    public static Movie convertMovieDtoToMovie(MovieRequestDto movieRequestDto){

        Movie movie = Movie.builder().movieName(movieRequestDto.getMovieName()).releaseDate(movieRequestDto.getReleaseDate()).build();
        return movie;
    }

    public static MovieResponseDto convertMovieToMovieResponseDto(Movie movie){

        List<Show> listOfShows = movie.getListOfShows();

        List<Integer> listOfShowsIds = new ArrayList<>();

        for(Show show : listOfShows)
            listOfShowsIds.add(show.getId());

        MovieResponseDto movieResponseDto = MovieResponseDto.builder().id(movie.getId()).movieName(movie.getMovieName()).releaseDate(movie.getReleaseDate()).showList(listOfShowsIds).build();

        return movieResponseDto;
    }
}
