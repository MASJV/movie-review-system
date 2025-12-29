package com.example.movie_review_system.exception;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message, Throwable reason){
        super(message, reason);
    }
    public MovieNotFoundException(String message){
        super(message);
    }
}
