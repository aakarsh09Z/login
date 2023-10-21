package com.example.login.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_id")
    private long id;
    @Column(name="users_name")
    private String username;
    @Column(name="users_email")
    private String email;
    @Column(name="users_password")
    private String password;

    public Users(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Users() {

    }

}
