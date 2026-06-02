package com.practice.movie_management.Repository;

import com.practice.movie_management.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

    List<Movie> findByTitleAndRating(String title, double rating);
}
//If an interviewer asks:
//
//Where is findById() implemented? Your repository is empty.
//
//A strong answer is:
//
//"MovieRepo extends JpaRepository<Movie, Integer>. JpaRepository a
// lready provides CRUD methods such as save(), findById(), findAll(),
// and deleteById(). Spring Data JPA generates the implementation
// at runtime using proxy classes, so we only declare the repository
// interface and inherit the functionality.