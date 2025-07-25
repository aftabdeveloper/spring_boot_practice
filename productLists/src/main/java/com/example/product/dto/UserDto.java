package com.example.product.dto;

public class UserDto {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
