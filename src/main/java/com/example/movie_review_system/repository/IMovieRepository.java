package com.example.movie_review_system.repository;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m")
    List<Movie> getAllMovies();

    // Get a single movie by id
    @Query("SELECT m FROM Movie m WHERE m.movieId = :movieId")
    Movie getAMovie(@Param("movieId") int movieId);

    // Find movies by actor name
    @Query("SELECT m FROM Movie m JOIN m.actorList a WHERE a.name = :name")
    List<Movie> findByActorName(@Param("name") String actorName);




}
