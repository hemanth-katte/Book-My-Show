package com.example.BookMyShow.Book.My.Show.Service;

import com.example.BookMyShow.Book.My.Show.Models.Show;
import com.example.BookMyShow.Book.My.Show.Models.ShowSeat;
import com.example.BookMyShow.Book.My.Show.Models.Ticket;
import com.example.BookMyShow.Book.My.Show.Models.User;
import com.example.BookMyShow.Book.My.Show.Repository.ShowRepository;
import com.example.BookMyShow.Book.My.Show.Repository.TicketRepository;
import com.example.BookMyShow.Book.My.Show.Repository.UserRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.TicketRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    public String bookTicket(TicketRequestDto bookTicketRequestDto) throws Exception{

        List<String> requestedSeats = bookTicketRequestDto.getRequestSeats();

        Show showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        User userEntity = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        //Get the showSeats from showEntity
        List<ShowSeat> showSeats = showEntity.getShowSeatList();

        //Validate if I can allocate these seats to the requested by user.

        List<ShowSeat> bookedSeats = new ArrayList<>();

        for(ShowSeat showSeat : showSeats){

            String seatNo = showSeat.getSeatNo();

            if(showSeat.isBooked()==false&&requestedSeats.contains(seatNo)){
                bookedSeats.add(showSeat);
            }
        }


        //FAILURE
        if(bookedSeats.size()!=requestedSeats.size()){
            //Some the seats the useRequested are not available
            throw new Exception("Requested seats are not available");
        }


        //SUCCESS
        //This means the bookedSeats actually contains the booked Seats.
        Ticket ticketEntity = new Ticket();

        double totalAmout = 0;
        double multiplier = showEntity.getMultiplier();


        String allotedSeats  = "";

        int rate = 0;
        //Calculating amount,setting bookedStatus, setting
        for(ShowSeat bookedSeat: bookedSeats){

            bookedSeat.setBooked(true);
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setTicket(ticketEntity);
            bookedSeat.setShow(showEntity);

            String seatNo = bookedSeat.getSeatNo();

            allotedSeats = allotedSeats + seatNo + ",";

            if(seatNo.charAt(0)=='1')
                rate = 100;
            else
                rate = 200;

            totalAmout = totalAmout + multiplier*rate;
        }

        ticketEntity.setBooked_at(new Date());
        ticketEntity.setAmount((int)totalAmout);
        ticketEntity.setShow(showEntity);
        ticketEntity.setUser(userEntity);
        ticketEntity.setBookedSeats(bookedSeats);
        ticketEntity.setAllotedSeats(allotedSeats);

        //Bidirectional mapping part is pending

        ticketRepository.save(ticketEntity);

        return "Sucessfully created a ticket";
    }
}
