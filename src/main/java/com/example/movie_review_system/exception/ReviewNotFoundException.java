package com.example.movie_review_system.exception;

public class ReviewNotFoundException extends Exception{
    public ReviewNotFoundException(String messgae, Throwable reason){
        super(messgae, reason);
    }
    public ReviewNotFoundException(String messgae){
        super(messgae);
    }
}
