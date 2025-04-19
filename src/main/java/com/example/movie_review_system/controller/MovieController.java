package com.example.movie_review_system.controller;

import com.example.movie_review_system.model.dto.CreateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movies")
@Slf4j

public class MovieController {

    @GetMapping
    public ResponseEntity<String> getAllMovies(
            @RequestParam(name = "search", required = false) String nameSearch, // movie name
            @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "50") int pageSize) {
        log.info("received a request to get all movies to with params {} {} {}", nameSearch, pageNo, pageSize);
        return ResponseEntity.ok("Got all movies");
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<String> getAMovie(@PathVariable("movieId") int movieId) {
        log.info("received a request to get a movie with id {}", movieId);
        return ResponseEntity.ok("Get a movie");
    }

    @PostMapping
    public ResponseEntity<String> createAMovie(@RequestBody CreateMovieRequestDto createMovieRequestDto) {
        log.info("received a request to create a movie with body {}", createMovieRequestDto);
        return ResponseEntity.ok("Create a movie");
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<String> deleteAMovie(@PathVariable("movieId") int movieId) {
        log.info("received a request to delete a movie with id {}", movieId);
        return ResponseEntity.ok("Delete a movie");
    }

    @PatchMapping("/{movieId}")
    public ResponseEntity<String> updateAMovie(@PathVariable("movieId") int movieId,
                                              @RequestBody UpdateMovieRequestDto updateMovieRequestDto) {
        log.info("received a request to update a ,movie with id {} {}", movieId, updateMovieRequestDto);
        return ResponseEntity.ok("Update a movie");
    }
}