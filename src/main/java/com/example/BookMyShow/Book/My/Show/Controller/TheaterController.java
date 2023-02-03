package com.example.BookMyShow.Book.My.Show.Controller;


import com.example.BookMyShow.Book.My.Show.RequestDto.TheaterRequestDto;
import com.example.BookMyShow.Book.My.Show.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add-theater")
    public String createTheater(@RequestBody TheaterRequestDto theaterRequestDto){

        return theaterService.createTheater(theaterRequestDto);
    }
}
