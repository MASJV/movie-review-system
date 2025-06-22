package com.example.movie_review_system.repository;

import com.example.movie_review_system.exception.ReviewNotFoundException;
import com.example.movie_review_system.model.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ReviewRepository implements IReviewRepository{

    public List<Review> reviewList;

    public ReviewRepository(){
        reviewList = new LinkedList<>();
    }

    @Override
    public Review getAReview(int reviewId) throws ReviewNotFoundException {
        for(Review review : reviewList){
            if(review.getReviewId() == reviewId) return review;
        }
        throw new ReviewNotFoundException("Review Not Found");
    }

    @Override
    public List<Review> getAllReviews(){
        return reviewList;
    }

    @Override
    public Review createAReview(Review review){
        reviewList.add(review);
        return review;
    }

    @Override
    public Review updateAReview(int reviewId, String title, String description, Double rating) throws ReviewNotFoundException{
        Review review = getAReview(reviewId);
        review.setTitle(title);
        review.setDescription(description);
        review.setRating(rating);
        return review;
    }

    @Override
    public void deleteAReview(int reviewId) throws ReviewNotFoundException{
        for(Review review : reviewList){
            if(review.getReviewId() == reviewId) reviewList.remove(review);
        }
        throw new ReviewNotFoundException("Review Not Found");
    }
}
