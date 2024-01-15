package com.example.domain.models.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Usuario {
    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String token;
    private String password;
    private String mobilePhone;
    private String email;
}