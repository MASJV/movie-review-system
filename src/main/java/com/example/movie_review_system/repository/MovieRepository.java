package com.example.movie_review_system.repository;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.model.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository // annotation for repository layer
public class MovieRepository implements IMovieRepository {

    public final List<Movie> movieList;

    public MovieRepository() {
        this.movieList = new LinkedList<>();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieList;
    }

    @Override
    public Movie getAMovie(int movieId) throws MovieNotFoundException {
        for (Movie movie : movieList) {
            if (movie.getMovieId() == movieId) return movie;
        }
        throw new MovieNotFoundException("Movie Not Found");
    }

    @Override
    public void createAMovie(Movie movie) {
        movieList.add(movie);
    }

    @Override
    public Movie updateAMovie(int movieId, String name, String trailorLink, String posterLink, String language, String genre) throws MovieNotFoundException {
        Movie movie = getAMovie(movieId); // utilises previous create getAMovie method
        movie.setName(name);
        movie.setTrailerLink(trailorLink);
        movie.setPosterLink(posterLink);
        movie.setLanguage(language);
        movie.setGenre(genre);
        return movie;
    }

    @Override
    public Movie deleteAMovie(int movieId) throws MovieNotFoundException {
        for (Movie movie : movieList) {
            if (movie.getMovieId() == movieId) {
                movieList.remove(movie);
                return movie;
            }
        }
        throw new MovieNotFoundException("Movie Not Found");
    }
}
    