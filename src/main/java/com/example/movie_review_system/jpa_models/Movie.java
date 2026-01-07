package com.example.movie_review_system.jpa_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(unique = true, nullable = false) // message instead of 400 error??
    private String name;

    @Column(unique = true, nullable = false) private String trailerLink;

    @Column(unique = true, nullable = false)  private String posterLink;

    @Column private Double avgRating;
    @Column private Integer totalRating = 0;
    @Column private int duration;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @ManyToMany(mappedBy = "watchList")
    private List<User> users;

    @Column private String language;
    private String genre;

    @Column(name = "release_year")
    private int releaseYear;

    @ManyToMany
    @JoinTable(
            name = "movie_actorList",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actorList = new ArrayList<>();


}

 