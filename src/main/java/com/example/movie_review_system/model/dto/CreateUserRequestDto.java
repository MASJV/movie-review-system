package com.example.movie_review_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder // not needed here
@AllArgsConstructor
public class CreateUserRequestDto {
    private final String name;
    private final Integer birthYear;
    private final String country;
}
/**
 * {
 *     "name": "Jaiveer",
 *     "birthYear": 2007,
 *     "country": "IND"
 * }
 *
 *
 */
