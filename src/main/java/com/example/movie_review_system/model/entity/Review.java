package com.example.movie_review_system.model.entity;

import lombok.Data;

@Data
public class Review {
    private static int counter = 0;
    private final int reviewId;
    private final Integer movieId;
    private final Integer userId;
    private String title;
    private String description;
    private Double rating;

    public Review(Integer movieId, Integer userId, String title, String description, Double rating) {
        this.reviewId = ++counter;
        this.movieId = movieId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Review(int reviewId, Integer movieId, Integer userId, String title, String description, Double rating) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    public static class ReviewBuilder {
        private int reviewId;
        private Integer movieId;
        private Integer userId;
        private String title;
        private String description;
        private Double rating;

        ReviewBuilder() {
        }

        public ReviewBuilder movieId(Integer movieId) {
            this.movieId = movieId;
            return this;
        }

        public ReviewBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public ReviewBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ReviewBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ReviewBuilder rating(Double rating) {
            this.rating = rating;
            return this;
        }

        public Review build() {
            return new Review(this.movieId, this.userId, this.title, this.description, this.rating);
        }

        public String toString() {
            return "Review.ReviewBuilder(reviewId=" + this.reviewId + ", movieId=" + this.movieId + ", userId=" + this.userId + ", title=" + this.title + ", description=" + this.description + ", rating=" + this.rating + ")";
        }
    }
}
