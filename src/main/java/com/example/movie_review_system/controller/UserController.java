package com.example.movie_review_system.controller;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.exception.UserNotFoundException;
import com.example.movie_review_system.model.dto.*;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.model.entity.User;
import com.example.movie_review_system.service.MovieService;
import com.example.movie_review_system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // mandatory
@RequestMapping("/api/v1/users") // batana padega resquest kisse shuru hota hai
                                 // (common prefix in all below requests)
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers( // ye page, search etc hata de???
            @RequestParam(name = "search", required = false) String nameSearch,
            @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "50") int pageSize) {
        log.info("received a request to get all users to with params {} {} {}", nameSearch, pageNo, pageSize);

        final List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getAUser(@PathVariable("userId") int userId) {
        log.info("received a request to get a users with id {}", userId);
        try {
            final User user = userService.getAUser(userId);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        log.info("received a request to get a users with body {}", createUserRequestDto);
        final User user = userService.createAUser(createUserRequestDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteAUser(@PathVariable("userId") int userId) {
        log.info("received a request to delete a user with id {}", userId);
        try {
            final User user = userService.deleteAUser(userId);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateAUser(@PathVariable("userId") int userId,
                                               @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        log.info("received a request to update a user with id {} {}", userId, updateUserRequestDto);
        try {
            final User user = userService.updateAUser(userId, updateUserRequestDto);
            return ResponseEntity.ok(user);
        } catch(UserNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch(Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    //add an end point to add to user watch list
    //private final MovieService movieService;
    @PatchMapping("/{userId}/watchList")
    public ResponseEntity<User> addMovieToWatchList(@PathVariable("userId") int userId,
                                                    @RequestBody AddMovieToWatchListDto addMovieToWatchListDto) {
        log.info("received a request to add movie with id {} to watchlist of user with id {}",
                addMovieToWatchListDto.getMovieId(), userId);
        try {
            final User user = userService.addMovieToWatchList(userId, addMovieToWatchListDto);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException | MovieNotFoundException ex) { // ask about this
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
        // what is functioning of request body means line 88 me dto 2nd param pe rakhke kaise chala
        // dto se movieid retrieve karke uses repo/servive (movie) se movie get karke nai aayega??
    }

    @DeleteMapping("/{userId}/watchList")
    public ResponseEntity<User> deleteMovieFromWatchList(@PathVariable("userId") int userId,
                                                         @RequestBody DeleteMovieFromWatchListDto deleteMovieFromWatchListDto) {
        log.info("received a request to delete movie with id {} from watchlist of user with id {}",
                                                        deleteMovieFromWatchListDto.getMovieId(), userId);
        try {
            final User user = userService.deleteMovieFromWatchList(userId, deleteMovieFromWatchListDto);
            return ResponseEntity.ok(user);
        } catch(UserNotFoundException | MovieNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch(Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
}