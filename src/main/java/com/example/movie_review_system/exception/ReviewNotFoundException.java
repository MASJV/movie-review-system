package com.example.movie_review_system.exception;

public class ReviewNotFoundException extends Exception{
    public ReviewNotFoundException(String message, Throwable reason){
        super(message, reason);
    }
    public ReviewNotFoundException(String message){
        super(message);
    }
}
