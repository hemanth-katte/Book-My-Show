package com.example.BookMyShow.Book.My.Show.Controller;

import com.example.BookMyShow.Book.My.Show.RequestDto.MovieRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(MovieRequestDto movieRequestDto){
        String ret =
    }
}
