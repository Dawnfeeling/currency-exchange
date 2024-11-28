package com.example.exchange.service;

import com.example.exchange.dto.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(String name, String email);

    void deleteUser(Long id);
}
