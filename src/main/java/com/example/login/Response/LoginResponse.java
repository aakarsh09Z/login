package com.example.login.Response;

import lombok.Data;

@Data
public class LoginResponse {

    String message;
    Boolean status;

    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
