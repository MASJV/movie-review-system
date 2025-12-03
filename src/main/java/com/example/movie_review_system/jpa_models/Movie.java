package com.example.movie_review_system.jpa_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
//@Builder
//@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Movie {
    //private static int movies = 0;
    //AUTO -> Hibernates would decide, hibernate decides based on DB dialect, MySQL -> Identy, Oracle -> Segence
    //Segunce -> based on segunece generator it woud genarte
    //IDENITY -> auto increment
    //TABLE -> reads from a table
    // UUID -> Random UUID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(unique = true, nullable = false) private String name;

    @Column(unique = true, nullable = false) private String trailerLink;

    @Column(unique = true, nullable = false)  private String posterLink;

    @Column private Double avgRating;
    @Column private Integer totalRating = 0;
    @Column private int duration;

    /*
  CASCADE -> 4 types
  PERSIST -> save parent, all children would be
  MERGE -> update parent, all children would be updated
  REMOVE -> delete parent, all children would be deleted
  ALL -> all 4 above
   */
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
            // custom index needed?
    )
    private List<Actor> actorList = new ArrayList<>(); // no need for final


}

 