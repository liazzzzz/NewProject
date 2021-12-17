package com.example.website.services;

import com.example.website.dto.SignUpDto;
import com.example.website.models.Role;
import com.example.website.models.State;
import com.example.website.models.User;
import com.example.website.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .firstname(form.getFirstname())
                .lastname(form.getLastname())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .build();

        usersRepository.save(user);
    }
}

