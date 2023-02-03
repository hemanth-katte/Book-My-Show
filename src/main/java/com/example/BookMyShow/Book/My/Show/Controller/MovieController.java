package com.example.BookMyShow.Book.My.Show.Controller;

import com.example.BookMyShow.Book.My.Show.RequestDto.MovieRequestDto;
import com.example.BookMyShow.Book.My.Show.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Book.My.Show.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDto movieRequestDto){

        String ret = movieService.saveMovie(movieRequestDto);

        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<MovieResponseDto> getMovieByName(@PathVariable String movieName){

        MovieResponseDto movieResponseDto = movieService.findByname(movieName);

        return new ResponseEntity<>(movieResponseDto,HttpStatus.OK);
    }
}
