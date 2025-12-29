package com.example.movie_review_system.service;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.model.dto.CreateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateMovieRequestDto;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public Movie createAMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie createAMovie(final CreateMovieRequestDto createMovieRequestDto) {
        final Movie movie = new Movie(
                createMovieRequestDto.getName(),
                createMovieRequestDto.getTrailerLink(),
                createMovieRequestDto.getPosterLink(),
                createMovieRequestDto.getLanguage(),
                createMovieRequestDto.getGenre()
        );
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public Movie getAMovie(int movieId) throws MovieNotFoundException {
        Movie movie = movieRepository.getAMovie(movieId);
        if(movie == null) {
            throw new MovieNotFoundException("Movie not found with id: " + movieId);
        }
        return movie;
    }

    public Movie updateAMovie(int movieId, final UpdateMovieRequestDto updateMovieRequestDto)
            throws MovieNotFoundException {

        Movie movie = getAMovie(movieId); // will throw if not found

        movie.setName(updateMovieRequestDto.getName());
        movie.setTrailerLink(updateMovieRequestDto.getTrailerLink());
        movie.setPosterLink(updateMovieRequestDto.getPosterLink());
        movie.setLanguage(updateMovieRequestDto.getLanguage());
        movie.setGenre(updateMovieRequestDto.getGenre());

        return movieRepository.save(movie);
    }

    public Movie deleteAMovie(int movieId) throws MovieNotFoundException {
        Movie movie = getAMovie(movieId); // will throw if not found
        movieRepository.delete(movie);
        return movie;
    }
}