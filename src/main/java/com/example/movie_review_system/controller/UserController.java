package com.example.movie_review_system.controller;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.exception.UserNotAbleToCreateException;
import com.example.movie_review_system.exception.UserNotFoundException;
import com.example.movie_review_system.model.dto.*;
import com.example.movie_review_system.model.dto.responseDto.CreateUserResponse;
import com.example.movie_review_system.model.dto.responseDto.CreateUserResponseData;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.model.entity.User;
import com.example.movie_review_system.model.response.ResponseMetaData;
import com.example.movie_review_system.model.response.ResponseWrapper;
import com.example.movie_review_system.service.MovieService;
import com.example.movie_review_system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("received a request to get all users");
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
    public ResponseEntity<ResponseWrapper<CreateUserResponseData>> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        log.info("received a request to create a user with body {}", createUserRequestDto);
        try {
            final User user = userService.createAUser(createUserRequestDto);
            final ResponseWrapper<CreateUserResponseData> response = CreateUserResponse.builder()
                    .user(CreateUserResponseData.builder()
                            .firstName(user.getName())
                            .birthYear(user.getBirthYear())
                            .country(user.getCountry())
                            .build())
                    .responseMetaData(ResponseMetaData.builder()
                            .statusCode(200)
                            .build())
                    .build();
            return ResponseEntity.ok(response);
        } catch (UserNotAbleToCreateException ex) {
            log.error("User not found: {}", ex.getMessage());
            final ResponseWrapper<CreateUserResponseData> userNotFound = CreateUserResponse.builder()
                    .responseMetaData(ResponseMetaData.builder()
                            .statusCode(404)
                            .errorMessage(ex.getMessage())
                            .build())
                    .build();
            return ResponseEntity.status(404).body(userNotFound);
        } catch (Exception ex) {
            log.error("Error occurred while creating user", ex);
            final ResponseWrapper<CreateUserResponseData> response = CreateUserResponse.builder()
                    .responseMetaData(ResponseMetaData.builder()
                            .statusCode(500) //5xx
                            .errorMessage(ex.getMessage())
                            .build())
                    .build();
            //return ResponseEntity.ok(response);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

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