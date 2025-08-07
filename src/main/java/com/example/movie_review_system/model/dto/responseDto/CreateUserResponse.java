package com.example.movie_review_system.model.dto.responseDto;

import com.example.movie_review_system.model.entity.User;
import com.example.movie_review_system.model.response.ResponseMetaData;
import com.example.movie_review_system.model.response.ResponseWrapper;
import lombok.Builder;

public class CreateUserResponse extends ResponseWrapper<CreateUserResponseData> {

    @Builder
    public CreateUserResponse(CreateUserResponseData user, ResponseMetaData responseMetaData) {
        super(user,responseMetaData);
    }

}
