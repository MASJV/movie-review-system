package com.example.movie_review_system.service;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.exception.ReviewNotFoundException;
import com.example.movie_review_system.model.dto.CreateReviewRequestDto;
import com.example.movie_review_system.model.dto.DeleteReviewRequestDto;
import com.example.movie_review_system.model.dto.UpdateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateReviewRequestDto;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.model.entity.Review;
import com.example.movie_review_system.repository.IMovieRepository;
import com.example.movie_review_system.repository.IReviewRepository;
import com.example.movie_review_system.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // annotation for service layer
@Slf4j
@RequiredArgsConstructor
public class ReviewService {
    private final IReviewRepository reviewRepository;  // servce imteracts with repository layer
    private final IMovieRepository movieRepository;

    public Review getAReview(int reviewId) throws ReviewNotFoundException {
        return reviewRepository.getAReview(reviewId);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    public Review createAReview(final CreateReviewRequestDto createReviewRequestDto) throws MovieNotFoundException {
        // but if final then how we can update it
        final Review review = new Review(createReviewRequestDto.getMovieId(), createReviewRequestDto.getUserId(),
                createReviewRequestDto.getTitle(), createReviewRequestDto.getDescription(),
                createReviewRequestDto.getRating());
        //fetch the movie & update it's rating
        final Movie movie = movieRepository.getAMovie(createReviewRequestDto.getMovieId());
        movie.addReview(review);

        return reviewRepository.createAReview(review);
    }

    public Review updateAReview(int reviewId, final UpdateReviewRequestDto updateReviewRequestDto) throws ReviewNotFoundException, MovieNotFoundException {
        // cannot we do in repo or service rather than creating another method in movie, or we need to as
        // its movie's attributes and defines a complete new process/method/action
        final Movie movie = movieRepository.getAMovie(updateReviewRequestDto.getMovieId());

        final Review reviewDelete = getAReview(reviewId);
        final Review reviewAdd = new Review(reviewId, updateReviewRequestDto.getMovieId(),
                updateReviewRequestDto.getUserId(), updateReviewRequestDto.getTitle(),
                updateReviewRequestDto.getDescription(), updateReviewRequestDto.getRating());
        // update avg. rating, total reviews
        movie.updateReview(reviewDelete, reviewAdd);
        // updating review
        return reviewRepository.updateAReview(reviewId, updateReviewRequestDto.getTitle(),
                updateReviewRequestDto.getDescription(), updateReviewRequestDto.getRating());
    }

    public Review deleleAReview(int reviewId, DeleteReviewRequestDto deleteReviewRequestDto) throws ReviewNotFoundException, MovieNotFoundException{
        final Movie movie = movieRepository.getAMovie(deleteReviewRequestDto.getMovieId());
        final Review review = getAReview(reviewId);
        movie.deleteReview(review);
        return reviewRepository.deleteAReview(reviewId);
    }

}