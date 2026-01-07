package com.example.movie_review_system.jpa_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
@AllArgsConstructor

public class Actor {
    private static int actors = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    @Column(nullable = false) private String name;
    @Column(nullable = false) private String dob;
    @Column(nullable = false) private Gender gender;

    @ManyToMany(mappedBy = "actorList")
    private List movies;

}
