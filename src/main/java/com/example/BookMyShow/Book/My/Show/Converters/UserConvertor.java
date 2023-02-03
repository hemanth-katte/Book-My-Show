package com.example.BookMyShow.Book.My.Show.Converters;

import com.example.BookMyShow.Book.My.Show.Models.Ticket;
import com.example.BookMyShow.Book.My.Show.Models.User;
import com.example.BookMyShow.Book.My.Show.RequestDto.UserRequestDto;
import com.example.BookMyShow.Book.My.Show.ResponseDto.UserResponseDto;

import java.util.ArrayList;
import java.util.List;

public class UserConvertor {

    public static User convertUserDtoToUser(UserRequestDto userRequestDto){

        User newUser = User.builder().name(userRequestDto.getName()).mobileNo(userRequestDto.getMobileNo()).build();
        return newUser;
    }

    public static UserResponseDto convertUserToUserResponseDto(User user){

        List<Ticket> ticketList = user.getTicketsListOfUser();

        List<Integer> ticketIdList = new ArrayList<>();

        for(Ticket ticket : ticketList)
            ticketIdList.add(ticket.getId());

        UserResponseDto userResponseDto = UserResponseDto.builder().name(user.getName()).mobileNo(user.getMobileNo()).ticketList(ticketIdList).build();

        return userResponseDto;
    }
}
