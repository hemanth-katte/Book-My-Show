package com.example.BookMyShow.Book.My.Show.Service;


import com.example.BookMyShow.Book.My.Show.Converters.UserConvertor;
import com.example.BookMyShow.Book.My.Show.Models.User;
import com.example.BookMyShow.Book.My.Show.Repository.UserRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.UserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
