package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UpdateMovieRequestDto {
    private final String name;
    //private final String trailorLink; ????
    //private final String posterLink; ????
}

/**
 * "name" : "Transformer: Age of Extinction"
 */
