package com.example.movie_review_system.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class ResponseMetaData {
    //private final String requestId;
    private final String errorMessage;
    private final Integer errorCode;
    private final int statusCode;
}
