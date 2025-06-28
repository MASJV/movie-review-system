package com.example.movie_review_system.repository;

import com.example.movie_review_system.exception.UserNotFoundException;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.model.entity.User;

import java.util.List;

public interface IUserRepository {
    User getAUser(int userId) throws UserNotFoundException;

    List<User> getAllUsers();

    void createAUser(User user);

    User updateAUser(int userId, String name) throws UserNotFoundException;

    User deleteAUser(int userId) throws UserNotFoundException;

    void addMovieToWatchList(User user, Movie movie) throws UserNotFoundException;

    void deleteMovieFromWatchList(User user, Movie movie) throws UserNotFoundException;
}