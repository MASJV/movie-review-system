package com.example.movie_review_system.controller;

import com.example.movie_review_system.model.dto.CreateUserRequestDto;
import com.example.movie_review_system.model.dto.UpdateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // mandatory
@RequestMapping("/api/v1/users") // batana padega resquest kisse shuru hota hai
                                 // (common prefix in all below requests)
@Slf4j
public class UserController {


    @GetMapping
    public ResponseEntity<String> getAllUsers(
            @RequestParam(name = "search", required = false) String nameSearch,
            @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "50") int pageSize) {
        log.info("received a request to get all users to with params {} {} {}", nameSearch, pageNo, pageSize);
        return ResponseEntity.ok("Got all users");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<String> getAUser(@PathVariable("userId") int userId) {
        log.info("received a request to get a users with id {}", userId);
        return ResponseEntity.ok("Get a user");
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        log.info("received a request to get a users with body {}", createUserRequestDto);
        return ResponseEntity.ok("Create a user");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteAUser(@PathVariable("userId") int userId) {
        log.info("received a request to delete a user with id {}", userId);
        return ResponseEntity.ok("Delete a user");
    }

    @PatchMapping("/{userId}") // patch as sara data update nahi ho raha hai
    public ResponseEntity<String> updateAUser(@PathVariable("userId") int userId,
                                              @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        log.info("received a request to update a user with id {} {}", userId, updateUserRequestDto);
        return ResponseEntity.ok("Update a user");
    }


}