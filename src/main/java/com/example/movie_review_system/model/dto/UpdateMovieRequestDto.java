package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UpdateMovieRequestDto {
    private final String name;
    private final String trailerLink;
    private final String posterLink;
    private final String genre;
    private final String language;
}

/**
 * "name" : "Transformer: Age of Extinction"
 */
