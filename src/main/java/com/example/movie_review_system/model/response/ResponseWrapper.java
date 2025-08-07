package com.example.movie_review_system.model.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ResponseWrapper <T> {
    protected final T data;
    protected final ResponseMetaData responseMetaData;

}
