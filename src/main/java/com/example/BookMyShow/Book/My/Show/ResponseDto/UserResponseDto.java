package com.example.BookMyShow.Book.My.Show.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponseDto {

    private int id;

    private String name;

    private String mobileNo;

    private List<Integer> ticketList;

}
