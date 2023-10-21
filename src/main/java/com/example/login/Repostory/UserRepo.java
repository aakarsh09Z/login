package com.example.login.Repostory;

import com.example.login.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

    Optional<Users>findOneByEmailAndPassword(String email,String password);
    Users findByEmail(String email);

}
