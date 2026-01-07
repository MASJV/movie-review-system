package com.example.movie_review_system.repository;

import com.example.movie_review_system.exception.ReviewNotFoundException;
import com.example.movie_review_system.model.entity.Review;

import java.util.List;

public interface IReviewRepository {
    Review getAReview(int reviewId) throws ReviewNotFoundException;
    List<Review> getAllReviews();
    Review createAReview(Review review);
    Review updateAReview(int reviewId, String title, String description, Double rating) throws ReviewNotFoundException;
    Review deleteAReview(int reviewId) throws ReviewNotFoundException;
}
