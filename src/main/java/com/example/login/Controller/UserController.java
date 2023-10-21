package com.example.login.Controller;


import com.example.login.DTO.UserDto;
import com.example.login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    public String saveUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }


}
