package com.example.BookMyShow.Book.My.Show.Service;

import com.example.BookMyShow.Book.My.Show.Converters.TheaterConvertor;
import com.example.BookMyShow.Book.My.Show.Enums.SeatType;
import com.example.BookMyShow.Book.My.Show.Models.Theater;
import com.example.BookMyShow.Book.My.Show.Models.TheaterSeat;
import com.example.BookMyShow.Book.My.Show.Repository.TheaterRepository;
import com.example.BookMyShow.Book.My.Show.Repository.TheaterSeatRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.TheaterRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TheaterService {
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String createTheater(TheaterRequestDto theaterRequestDto){

        try {
            Theater newTheater = TheaterConvertor.convertTheaterRequestDtoToTheater(theaterRequestDto);

            List<TheaterSeat> newTheaterSeats = createTheaterSeats();

            newTheater.setTheaterSeatList(newTheaterSeats);

            for (TheaterSeat theaterSeat : newTheaterSeats) {
                theaterSeat.setTheater(newTheater);
            }

            theaterRepository.save(newTheater);

            return "New theater added successfully";

        }catch (Exception e){
            log.info(e.toString());
            return e.toString();
        }

    }

    private List<TheaterSeat> createTheaterSeats(){

        List<TheaterSeat> newTheaterSeats = new ArrayList<>();

        for(int i =0;i<5;i++){
            char ch = (char) ((char)'A'+i);
            String seatNo = "1"+ch;
            TheaterSeat theaterSeat = new TheaterSeat(seatNo, SeatType.ClASSIC, 100);
            newTheaterSeats.add(theaterSeat);
        }

        for(int i =0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo = "2"+ch;
            TheaterSeat theaterSeat = new TheaterSeat(seatNo,SeatType.PLATINUM,200);
            newTheaterSeats.add(theaterSeat);
        }

        theaterSeatRepository.saveAll(newTheaterSeats);

        return newTheaterSeats;
    }
}
