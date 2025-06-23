package com.example.movie_review_system.controller;

import com.example.movie_review_system.exception.MovieNotFoundException;
import com.example.movie_review_system.exception.UserNotFoundException;
import com.example.movie_review_system.model.dto.CreateUserRequestDto;
import com.example.movie_review_system.model.dto.UpdateMovieRequestDto;
import com.example.movie_review_system.model.dto.UpdateUserRequestDto;
import com.example.movie_review_system.model.entity.Movie;
import com.example.movie_review_system.model.entity.User;
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
    public ResponseEntity<List<User>> getAllUsers(
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
    public ResponseEntity<String> updateAUser(@PathVariable("userId") int userId,
                                               @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        log.info("received a request to update a ,user with id {} {}", userId, updateUserRequestDto);
        return ResponseEntity.ok("Update a user");
    }

    //add an end point to add to user watch list
}