package com.example.login.Service;

import com.example.login.DTO.UserDto;
import com.example.login.Entity.Users;
import com.example.login.Repostory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {

            Users users=new Users(

            userDto.getId(),
            userDto.getUsername(),
            userDto.getEmail(),

            this.passwordEncoder.encode(userDto.getPassword())
        );
        userRepo.save(users);

        return users.getUsername();
    }
}
