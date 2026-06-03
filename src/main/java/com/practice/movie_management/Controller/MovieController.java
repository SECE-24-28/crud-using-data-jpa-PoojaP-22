package com.practice.movie_management.Controller;

import com.practice.movie_management.Entity.Movie;
import com.practice.movie_management.Service.MovieAdvance;
//import com.practice.movie_management.Service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")

public class MovieController {
    @Autowired
    private MovieAdvance movie;

    //List all Movies
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movie.getAll());
    }

    //List Movie by id
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable int id) {
        return ResponseEntity.ok(movie.getId(id));
    }

    //Add new Movie List
    @PostMapping("/list")
    public ResponseEntity<List<Movie>> addNew(@RequestBody List<@Valid Movie> m) {
        return ResponseEntity.ok(movie.addMovieAll(m));
    }

    //Add new Movie
    @PostMapping("/new")
    public ResponseEntity<Movie> addNewList(@Valid @RequestBody Movie m) {
        return ResponseEntity.ok(movie.addMovie(m));
    }

    //Update Movie
    @PutMapping("/update")
    public ResponseEntity<Movie> update(@Valid @RequestBody Movie m) {
        return ResponseEntity.ok(movie.updateMovie(m));
    }

    //Delete Movie by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok(movie.deleteMovie(id));
    }

    //Delete ALL Movies
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok(movie.deleteAll());
    }

    //List Movie based on params
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> getMoviesByTitleAndRating(
            @RequestParam String title,
            @RequestParam double rating) {

        return ResponseEntity.ok(
                movie.getMoviesByTitleAndRating(title, rating)
        );
    }

    @GetMapping("/{rating}")
    public ResponseEntity<List<Movie>> getMovieByRating(@PathVariable("rating") double rating){
        return ResponseEntity.ok(movie.getMovieByRating(rating));
    }

    @PostMapping("/filter")
    public List<Movie> getMovieByTandR(@Valid
            @Param("title") String title,
            @Param("rating") double rating
    ){
        return movie.getMovieByTandR(title,rating);
    }

}
