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

@Service // annotation for service layer
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository; //loosely couple

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }
    public Movie getAMovie(int movieId) throws MovieNotFoundException {
        return movieRepository.getAMovie(movieId);
    }

    public Movie createAMovie(final CreateMovieRequestDto createMovieRequestDto){
        final Movie movie = new Movie(createMovieRequestDto.getName(), createMovieRequestDto.getTrailerLink(),
                        createMovieRequestDto.getPosterLink(), createMovieRequestDto.getLanguage(),
                        createMovieRequestDto.getGenre());
        movieRepository.createAMovie(movie);
        return movie;
    }
    public Movie updateAMovie(int movieId, final UpdateMovieRequestDto updateMovieRequestDto) throws MovieNotFoundException{
        return movieRepository.updateAMovie(movieId, updateMovieRequestDto.getName(),
                updateMovieRequestDto.getTrailerLink(), updateMovieRequestDto.getPosterLink(),
                updateMovieRequestDto.getLanguage(), updateMovieRequestDto.getGenre());
    }

    public Movie deleteAMovie(int movieId) throws MovieNotFoundException{
        return movieRepository.deleteAMovie(movieId);
    }

}
