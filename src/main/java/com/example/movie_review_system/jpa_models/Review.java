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
    // movieId is foreign key in review table. batana padega foreign key ka naam.
    @JoinColumn(name = "movie_id", nullable = false) // nullable = false -> jo bhi review hoga eska movie hoga hi hoga
    private Movie movie; // JPA entity(object) ko relation me convert kar sakta hai
    // JPA object point of view se dekhta hai. JPA will provide the abstraction
    // hibernetes automatically will create ye movie ko reference kar raha hai so uska id yaha foreign key hai
    // entity hi dena padega. Good thing movie is @Entity
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    // foreign key to write??? not written in mine but others written. dedicated name. how join see.
    // join column means foreign key importing?
    private User user;

    @Column(unique = true, nullable = false) private String title;
    @Column(unique = true, nullable = false) private String description;
    @Column(unique = true, nullable = false) private Double rating;

    //can use @AllArgsCOnstructor to replace this?
    public Review(String title, String description, Double rating, User user, Movie movie) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.user = user;
        this.movie = movie;
    }


}
