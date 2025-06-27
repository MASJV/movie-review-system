package com.example.movie_review_system.service;


import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.exception.UserNotFoundException;
import com.example.movie_review_system.model.dto.AddMovieToWatchListDto;
import com.example.movie_review_system.model.dto.CreateUserRequestDto;
import com.example.movie_review_system.model.dto.DeleteMovieFromWatchListDto;
import com.example.movie_review_system.model.dto.UpdateUserRequestDto;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.model.entity.User;
import com.example.movie_review_system.repository.IMovieRepository;
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
    private final IMovieRepository movieRepository;

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
        // yaha ye business logic to repository kar raha hai? repo ka code yaha pe bhi nahi kar sakte????
    }

    public User deleteAUser(int userId) throws UserNotFoundException {
        return userRepository.deleteAUser(userId);
    }

    public User addMovieToWatchList(int userId, final AddMovieToWatchListDto addMovieToWatchListDto) throws UserNotFoundException, MovieNotFoundException{
        int movieId = addMovieToWatchListDto.getMovieId();
        User user = userRepository.getAUser(userId); // final why important(mandatory), without final also working????
        Movie movie = movieRepository.getAMovie(movieId);
        // user.addMovieToWatchList(movie); does this work?? ya service interacts with repository so not preferred
        userRepository.addMovieToWatchList(userId, movie);
        return user;
    }

    public User deleteMovieFromWatchList(int userId, DeleteMovieFromWatchListDto deleteMovieFromWatchListDto) throws UserNotFoundException, MovieNotFoundException{
        int movieId = deleteMovieFromWatchListDto.getMovieId();
        final User user = getAUser(userId);
        final Movie movie = movieRepository.getAMovie(movieId);
        userRepository.deleteMovieFromWatchList(userId, movie);
        return user;


    }


}