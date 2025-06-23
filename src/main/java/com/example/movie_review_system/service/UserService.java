package com.example.movie_review_system.service;


import com.example.movie_review_system.exception.UserNotFoundException;
import com.example.movie_review_system.model.dto.CreateUserRequestDto;
import com.example.movie_review_system.model.dto.UpdateUserRequestDto;
import com.example.movie_review_system.model.entity.User;
import com.example.movie_review_system.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public User getAUser(int userId) throws UserNotFoundException {
        return userRepository.getAUser(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User createAUser(final CreateUserRequestDto createUserRequestDto) {
        final User user = new User(createUserRequestDto.getName(), createUserRequestDto.getBirthYear(),
                createUserRequestDto.getCountry());
        userRepository.createAUser(user);
        return user;
    }

    public User updateAUser(int userId, final UpdateUserRequestDto updateUserRequestDto) throws UserNotFoundException {
        return userRepository.updateAUser(userId, updateUserRequestDto.getName());
    }

    public User deleteAUser(int userId) throws UserNotFoundException {
        return userRepository.deleteAUser(userId);
    }
}