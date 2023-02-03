package com.example.BookMyShow.Book.My.Show.Service;

import com.example.BookMyShow.Book.My.Show.Controller.MovieController;
import com.example.BookMyShow.Book.My.Show.Converters.MovieConvertor;
import com.example.BookMyShow.Book.My.Show.Models.Movie;
import com.example.BookMyShow.Book.My.Show.Repository.MovieRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.MovieRequestDto;
import com.example.BookMyShow.Book.My.Show.ResponseDto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String saveMovie(MovieRequestDto movieRequestDto){

        Movie movie = MovieConvertor.convertMovieDtoToMovie(movieRequestDto);

        movieRepository.save(movie);

        return "Movie successfully created";
    }

    public MovieResponseDto findByname(String movieName){

        Movie movie = movieRepository.findBymovieName(movieName);

        MovieResponseDto movieResponseDto = MovieConvertor.convertMovieToMovieResponseDto(movie);

        return movieResponseDto;
    }



}
