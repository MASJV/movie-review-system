package com.example.movie_review_system.repository;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.model.entity.Movie;

import java.util.List;

public interface IMovieRepository {
    // yaha pe public Movie etc ya without public??
    List<Movie> getAllMovies();
    Movie getAMovie(int movieId) throws MovieNotFoundException;
    void createAMovie(Movie movie);
    Movie updateAMovie(int movieId, String name, String trailorLink, String posterLink,
                      String language, String genre) throws MovieNotFoundException;// no Movie movie
    Movie deleteAMovie(int movieId) throws MovieNotFoundException;
}
