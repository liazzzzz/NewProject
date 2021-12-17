package com.example.website.services;

import com.example.website.dto.UserDto;
import com.example.website.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<UserDto> getAllUsers();

    void deleteUser(Long userId);

    Optional<User> findUserByEmail(String email);
}

