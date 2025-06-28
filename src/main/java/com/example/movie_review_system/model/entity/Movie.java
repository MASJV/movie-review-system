package com.example.movie_review_system.model.entity;

import com.example.movie_review_system.model.dto.UpdateReviewRequestDto;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//@Builder
public class Movie {
    private static int movies = 0;
    private final Integer movieId;
    private String name;
    private String trailerLink;
    private String posterLink;
    private Double avgRating;
    private Integer totalRating;
    private final List<Review> reviews; // undar update ho sakta hai but address will remain same
    private String language;
    private String genre; // create an enum

    public Movie(String name, String trailerLink, String posterLink, String language, String genre) {
        this.movieId = ++movies;
        this.name = name;
        this.trailerLink = trailerLink;
        this.posterLink = posterLink;
        this.language = language;
        this.genre = genre;
        this.reviews = new ArrayList<>();
        this.avgRating = 0.0;
        //this.totalNumberOfRating = 0; can be get from size of reviews(list)
    }

    public void addReview(Review review){
        this.reviews.add(review);
        avgRating = (avgRating * (reviews.size() - 1) + review.getRating())/(double)reviews.size();
    }

    public void deleteReview(Review review) {
        int size = reviews.size();
        this.reviews.remove(review);
        avgRating = ((avgRating * size) - review.getRating())/((size - 1));
    }

    public void updateReview(Review reviewDelete, Review reviewAdd) {
        deleteReview(reviewDelete);
        addReview(reviewAdd);
    }
}

 