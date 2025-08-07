package com.example.movie_review_system.model.dto.responseDto;

import com.example.movie_review_system.model.response.ResponseMetaData;
import com.example.movie_review_system.model.response.ResponseWrapper;
import lombok.Builder;

public class GetAUserResponse extends ResponseWrapper<GetAUserResponseData> {

    @Builder
    public GetAUserResponse(GetAUserResponseData user, ResponseMetaData responseMetaData) {
        super(user, responseMetaData);
    }
}
