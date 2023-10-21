package com.example.login.Service;

import com.example.login.DTO.LoginDto;
import com.example.login.DTO.UserDto;
import com.example.login.Response.LoginResponse;

public interface UserService {

    String addUser(UserDto userDto);

    LoginResponse loginUser(LoginDto loginDto);

}
