package com.example.exchange.service.user;

import com.example.exchange.dto.user.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(String name, String email);

    void deleteUser(Long id);
}
