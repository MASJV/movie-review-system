package com.example.movie_review_system.model.entity;

import com.example.movie_review_system.service.MovieService;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@Data //-> @getter, @Setter, @RequiredArgConstructor, @ToString, @EqualHashCode
//@Builder // goal of builder is to build immutable objects
@Getter
@Setter
@ToString
public class User { // user ek data model hai
    private static int users = 0;
    private final Integer userId;
    private String name;
    private final Integer birthYear; // will display age (age needs to be updated every year
    private final String country;
    private final List<Movie> watchList;

    public User(String name, Integer birthYear, String country) {
        this.userId = ++users;
        this.name = name;
        this.birthYear = birthYear;
        this.country = country;
        this.watchList =  new ArrayList<>();
    }

    public void addMovieToWatchList(Movie movie) {
        this.watchList.add(movie);
    }

    public void deleteMovieFromWatchList(Movie movie) {
        this.watchList.remove(movie);
    }

    // watchList is reference. watchList memory address is fixed so final
    // movies inside watchList can be updated that's fine

}
