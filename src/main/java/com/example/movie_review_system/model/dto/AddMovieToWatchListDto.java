package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.print.attribute.standard.PrintQuality;

@Data
@AllArgsConstructor
public class AddMovieToWatchListDto {
    //private final Integer userId; // why not int as this cannot be null.
    private final Integer movieId;
}

/**
 * {
 *     "movieId": 1
 * }
 *
 *
 */