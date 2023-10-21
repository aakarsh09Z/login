package com.example.login.Service;

import com.example.login.DTO.LoginDto;
import com.example.login.DTO.UserDto;
import com.example.login.Entity.Users;
import com.example.login.Repostory.UserRepo;
import com.example.login.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {

        String msg="";
        Users user1=userRepo.findByEmail(loginDto.getEmail());
        if(user1!=null){
            String password=loginDto.getPassword();
            String encodedPassword=user1.getPassword();
            Boolean check=passwordEncoder.matches(password,encodedPassword);
            if(check){
                Optional<Users> users=userRepo.findOneByEmailAndPassword(loginDto.getEmail(),encodedPassword);
                if(users.isPresent()){
                    return new LoginResponse("Login Success",true);
                }
                else{
                    return new LoginResponse("Login Failed",false);
                }
            }
            else{
                return new LoginResponse("Wrong Password",false);
            }
        }
        else{
            return new LoginResponse("Email doesnot exist",false);
        }

    }
}
