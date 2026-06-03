package com.practice.movie_management.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDTO {
    @Id
    private int id;

    @NotBlank(message = "Title is Required")
    private String title;

    @NotBlank(message = "Name is Required")
    private String director;
    private double rating;

    @Email(message = "Provide valid E-mail")
    private String email;

    //private String password;
}
