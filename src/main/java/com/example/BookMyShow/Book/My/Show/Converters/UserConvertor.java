package com.example.BookMyShow.Book.My.Show.Converters;

import com.example.BookMyShow.Book.My.Show.Models.User;
import com.example.BookMyShow.Book.My.Show.RequestDto.UserRequestDto;

public class UserConvertor {

    public static User convertUserDtoToUser(UserRequestDto userRequestDto){

        User newUser = User.builder().name(userRequestDto.getName()).mobileNo(userRequestDto.getMobileNo()).build();
        return newUser;
    }
}
