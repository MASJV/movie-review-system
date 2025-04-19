package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UpdateUserRequestDto {
    private final String name;
    //private final Integer birthYear;
    //private final String Country;
    // no need to let user update birthYear and Country
}

/**
 * "name": "JV"
 */
