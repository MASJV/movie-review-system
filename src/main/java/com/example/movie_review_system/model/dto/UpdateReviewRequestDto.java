package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UpdateReviewRequestDto {
    private final Integer movieId;
    private final Integer userId;
    private final String title;
    private final String description;
    private final Double rating;
}

/**
 * {
 *     "rating" : "4"
 * }
 */
