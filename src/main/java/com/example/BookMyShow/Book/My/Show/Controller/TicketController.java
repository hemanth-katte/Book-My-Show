package com.example.BookMyShow.Book.My.Show.Controller;


import com.example.BookMyShow.Book.My.Show.Repository.TicketRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.TicketRequestDto;
import com.example.BookMyShow.Book.My.Show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book-ticket")
    public String bookTickets(@RequestBody TicketRequestDto ticketRequestDto){
        try{
            ticketService.bookTicket(ticketRequestDto);
            return "Tickets booked successfully";
        }catch (Exception e){
            return "Requested seats not available";
        }
    }
}
