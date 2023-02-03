package com.example.BookMyShow.Book.My.Show.Controller;


import com.example.BookMyShow.Book.My.Show.RequestDto.ShowRequestDto;
import com.example.BookMyShow.Book.My.Show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add-show")
    public String addShow(@RequestBody ShowRequestDto showRequestDto){
        return showService.createShow(showRequestDto);
    }
}
