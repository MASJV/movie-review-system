package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UpdateUserRequestDto {
    private final String name;
}

/**
 * "userId": 1,
 * "name": "JV"
 */
