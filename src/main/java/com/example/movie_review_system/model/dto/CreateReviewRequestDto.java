package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateReviewRequestDto {
    private final Integer movieId;
    private final Integer userId;
    private final String title;
    private final String description;
    private final Double rating;
}

/**
 * {
 *     "movieId": 1,
 *     "userId": 1,
 *     "title": "Movie Rating",
 *     "description": "Movie was good",
 *     "rating": 4.5
 * }
 *
 *
 */
