package com.example.BookMyShow.Book.My.Show.Service;


import com.example.BookMyShow.Book.My.Show.Converters.UserConvertor;
import com.example.BookMyShow.Book.My.Show.Models.User;
import com.example.BookMyShow.Book.My.Show.Repository.UserRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.UserRequestDto;
import com.example.BookMyShow.Book.My.Show.ResponseDto.UserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String saveUser(UserRequestDto userRequestDto){

        try {
            User newUser = UserConvertor.convertUserDtoToUser(userRequestDto);
            userRepository.save(newUser);
        }
        catch (Exception e){
            log.info("User could not be created");
            return "error in user creation";
        }

        return "user successfully created";
    }

    public UserResponseDto findUserByName(String userName){

        try
        {
            User user = userRepository.findByname(userName);
            UserResponseDto userResponseDto = UserConvertor.convertUserToUserResponseDto(user);
            return userResponseDto;
        }
        catch (Exception e){
            log.info(e.toString());
        }

        return null;
    }

    public List<UserResponseDto> findAllUsers(){
        try{
            List<User> usersList = userRepository.findAll();
            List<UserResponseDto> userDtoList = new ArrayList<>();

            for(User user : usersList){
                UserResponseDto userResponseDto = UserConvertor.convertUserToUserResponseDto(user);
                userDtoList.add(userResponseDto);
            }
            return userDtoList;
        }catch (Exception e){
            log.info(e.toString());
        }

        return null;

    }
}
