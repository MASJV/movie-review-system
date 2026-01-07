package com.example.movie_review_system.jpa_models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;
    private int birthYear;
    private String country;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @ManyToMany
    @JoinTable(
            name = "user_watchlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> watchList;

    public User(String name, int birthYear, String country) {
        this.name = name;
        this.birthYear = birthYear;
        this.country = country;
        this.watchList = new ArrayList<>();
        this.reviewList = new ArrayList<>();
    }

    public void addMovieToWatchList(Movie movie) {
        this.watchList.add(movie);
    }

    public void deleteMovieFromWatchList(Movie movie) {
        this.watchList.remove(movie);
    }

    public List<Movie> getWatchList() {
        if(watchList.isEmpty()) return null;
        else return watchList;
    }

    public void addReview(Review review){
        this.reviewList.add(review);
    }

    public void deleteReview(Review review) {
        this.reviewList.remove(review);
    }

}
/*
 user_watchlist
 id, user_id, movie_id
 1  1 1
 2  1, 2
 3 2 1
 4 2 2

 */