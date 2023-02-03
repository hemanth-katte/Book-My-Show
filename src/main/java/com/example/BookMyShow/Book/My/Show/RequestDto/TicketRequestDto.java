package com.example.BookMyShow.Book.My.Show.RequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TicketRequestDto {

    private List<String> requestSeats;

    private int userId;

    private int showId;

}
