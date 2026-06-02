package com.practice.movie_management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    //Auto generated id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer id;
    private int id;
    private String title;
    private String director;
    private double rating;
}
