package com.example.exchange.service;

import com.example.exchange.dto.UserResponseDto;
import com.example.exchange.entity.User;
import com.example.exchange.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(String name, String email) {

        User user = new User(name, email);
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}
