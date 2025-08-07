package com.example.movie_review_system.exception;

public class UserNotAbleToCreateException extends Exception {
    public UserNotAbleToCreateException(String messgae, Throwable reason){
        super(messgae, reason);
    }
    public UserNotAbleToCreateException(String message){
        super(message);
    }
}
