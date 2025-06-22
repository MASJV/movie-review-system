package com.example.movie_review_system.exception;

import com.example.movie_review_system.repository.MovieRepository;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message, Throwable reason){
        super(message, reason);
    }
    public MovieNotFoundException(String message){
        super(message);
    }
}
