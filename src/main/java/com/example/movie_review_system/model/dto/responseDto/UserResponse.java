package com.example.movie_review_system.model.dto.responseDto;

import com.example.movie_review_system.model.response.ResponseMetaData;
import com.example.movie_review_system.model.response.ResponseWrapper;
import lombok.Builder;

public class UserResponse extends ResponseWrapper<UserResponseData> {

    @Builder
    public UserResponse(UserResponseData user, ResponseMetaData responseMetaData) {
        super(user,responseMetaData);
    }

}
