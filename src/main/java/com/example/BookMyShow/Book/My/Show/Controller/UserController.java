package com.example.BookMyShow.Book.My.Show.Controller;

import com.example.BookMyShow.Book.My.Show.Repository.UserRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.UserRequestDto;
import com.example.BookMyShow.Book.My.Show.ResponseDto.UserResponseDto;
import com.example.BookMyShow.Book.My.Show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add-user")
    public ResponseEntity<String> addBook(@RequestBody UserRequestDto userRequestDto){
        String ret = userService.saveUser(userRequestDto);
        return new ResponseEntity<>(ret,HttpStatus.CREATED);
    }

    @GetMapping("/find-user/{user}")
    public ResponseEntity<UserResponseDto> findUserByName(@PathVariable String userName){

        UserResponseDto userResponseDto = userService.findUserByName(userName);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @GetMapping("/find-all-users")
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
        List<UserResponseDto> userResponseDtos = userService.findAllUsers();

        return new ResponseEntity<>(userResponseDtos,HttpStatus.OK);
    }



}
