package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder // not needed here
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
