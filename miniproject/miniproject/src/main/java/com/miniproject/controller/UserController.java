package com.miniproject.controller;

import com.miniproject.payloadDto.UserDto;
import com.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return new ResponseEntity<>("the User have been registered successfully.", HttpStatus.OK);
    }
}
