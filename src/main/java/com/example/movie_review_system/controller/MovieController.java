package com.example.movie_review_system.controller;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.model.dto.CreateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateUserRequestDto;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.repository.MovieRepository;
import com.example.movie_review_system.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@Slf4j
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(
            @RequestParam(name = "search", required = false) String nameSearch, // movie name
            @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "50") int pageSize) {
        log.info("received a request to get all movies to with params {} {} {}", nameSearch, pageNo, pageSize);

            final List<Movie> movies = movieService.getAllMovies();
            return ResponseEntity.ok(movies);

    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getAMovie(@PathVariable("movieId") int movieId) {
        log.info("received a request to get a movie with id {}", movieId);
        try {
            final Movie movie = movieService.getAMovie(movieId);
            return ResponseEntity.ok(movie);
        } catch (MovieNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }

    }

    @PostMapping
    public ResponseEntity<Movie> createAMovie(@RequestBody CreateMovieRequestDto createMovieRequestDto) {
        log.info("received a request to create a movie with body {}", createMovieRequestDto);
        final Movie movie = movieService.createAMovie(createMovieRequestDto);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Movie> deleteAMovie(@PathVariable("movieId") int movieId) {
        log.info("received a request to delete a movie with id {}", movieId);
        try {
            final Movie movie = movieService.deleteAMovie(movieId);
            return ResponseEntity.ok(movie);
        } catch (MovieNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{movieId}")
    public ResponseEntity<Movie> updateAMovie(@PathVariable("movieId") int movieId,
                                              @RequestBody UpdateMovieRequestDto updateMovieRequestDto) {
        log.info("received a request to update a ,movie with id {} {}", movieId, updateMovieRequestDto);
        try {
            final Movie movie = movieService.updateAMovie(movieId, updateMovieRequestDto);
            return ResponseEntity.ok(movie);
        } catch (MovieNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }

    }
}