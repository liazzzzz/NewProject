package com.example.website.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
