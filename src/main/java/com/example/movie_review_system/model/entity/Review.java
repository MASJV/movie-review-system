package com.example.movie_review_system.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {
    private final String movieId;
    private String title;
    private String description;
    private Double rating;
    private Integer upVote;
    private Integer downVote;
}
