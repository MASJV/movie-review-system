package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CreateMovieRequestDto {
    private final String name;
    private final String trailerLink;
    private final String posterLink;
    private final String language;
    private final String genre;
}

/**
 * {
 *     "name": "Transformers",
 *     "trailerLink": "youtube.com",
 *     "posterLink": "img.png"
 * }
 *
 *
 */
