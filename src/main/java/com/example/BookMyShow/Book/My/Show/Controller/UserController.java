package com.example.BookMyShow.Book.My.Show.Controller;

import com.example.BookMyShow.Book.My.Show.Repository.UserRepository;
import com.example.BookMyShow.Book.My.Show.RequestDto.UserRequestDto;
import com.example.BookMyShow.Book.My.Show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add-user")
    public ResponseEntity<String> addBook(UserRequestDto userRequestDto){
        String ret = userService.saveUser(userRequestDto);
        return new ResponseEntity<>(ret,HttpStatus.CREATED);
    }



}
