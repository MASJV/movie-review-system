package com.example.movie_review_system.jpa_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    // foreign key to write??? not written in mine but others written. dedicated name. how join see.
    // join column means foreign key importing?
    private User user;

    @Column(unique = true, nullable = false) private String title;
    @Column(unique = true, nullable = false) private String description;
    @Column(unique = true, nullable = false) private Double rating;

    public Review(String title, String description, Double rating, User user, Movie movie) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.user = user;
        this.movie = movie;
    }


}
