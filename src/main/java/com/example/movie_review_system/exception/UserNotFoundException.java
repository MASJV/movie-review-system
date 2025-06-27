package com.example.movie_review_system.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message, Throwable reason){
        super(message, reason);
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
