package com.example.login.Controller;


import com.example.login.DTO.UserDto;
import com.example.login.Response.LoginResponse;
import com.example.login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

//    @PostMapping(path = "/login")
//    public ResponseEntity<> loginUser(@RequestBody UserDto userDto){
//        LoginResponse loginResponse=UserService.loginUser(loginDto);
//        return ResponseEntity.ok(loginResponse);
//    }


}
