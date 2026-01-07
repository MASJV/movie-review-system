package com.example.movie_review_system.model.dto.responseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseData {

    private final String firstName;
    private final Integer birthYear;
    private final String country;
}
