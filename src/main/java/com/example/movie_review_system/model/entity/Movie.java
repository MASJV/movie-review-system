package com.example.movie_review_system.model.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Movie {
    private final Integer movieId;
    private String name;
    private String trailerLink;
    private String posterLink;
    private Double avgRating;
    private Integer totalRating;
    private final List<Review> reviews; // undar update ho sakta hai but address will remain same
    private String language;
    private String genre; // create an enum

}
