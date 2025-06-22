package com.example.movie_review_system.controller;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.exception.ReviewNotFoundException;
import com.example.movie_review_system.model.dto.CreateReviewRequestDto;
import com.example.movie_review_system.model.dto.UpdateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateReviewRequestDto;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.model.entity.Review;
import com.example.movie_review_system.service.MovieService;
import com.example.movie_review_system.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reviews") // or vi/movies/reviews?
@Slf4j
@RequiredArgsConstructor
public class ReviewController {
    // get a review, get all reviews?
    //create review
    //remove review
    //update review

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createAReview(@RequestBody CreateReviewRequestDto createReviewRequestDto) throws MovieNotFoundException {
        log.info("received a request to create a review with body {}", createReviewRequestDto);
        final Review review = reviewService.createAReview(createReviewRequestDto);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Review> deleteAReview(@PathVariable("reviewId") int reviewId) {
        log.info("received a request to delete a review with id {}", reviewId);
        try {
            final Review review = reviewService.getAReview(reviewId);
            return ResponseEntity.ok(review);
        } catch (ReviewNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{reviewId}")
    public ResponseEntity<String> updateAReview(@PathVariable("reviewId") int reviewId,
                                               @RequestBody UpdateReviewRequestDto updateReviewRequestDto) {
        log.info("received a request to update a review with id {} {}", reviewId, updateReviewRequestDto);
        return ResponseEntity.ok("Update a review");
    }


//
/*
// there is a movie
 -> user1 created review 1, rating 7 -> 7
 -> user 2 created review 2, rating 9 -> (7*current size+9)/current size +1
 -> avg would be updatd
 -> moview review list would be updatdd

 -> removal avg how it wpould be updatred


*/

}
