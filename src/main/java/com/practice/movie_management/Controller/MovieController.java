package com.practice.movie_management.Controller;

import com.practice.movie_management.Entity.Movie;
import com.practice.movie_management.Repository.MovieRepo;
import com.practice.movie_management.Service.MovieAdvance;
//import com.practice.movie_management.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")

public class MovieController {
    @Autowired
    private MovieAdvance movie;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movie.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable int id){
        return ResponseEntity.ok(movie.getId(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Movie> addNew(@RequestBody Movie m){
        return ResponseEntity.ok(movie.addMovie(m));
    }

    @PutMapping("/update")
    public ResponseEntity<Movie> update(@RequestBody Movie m) {
        return ResponseEntity.ok(movie.updateMovie(m));
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Movie> update(@PathVariable int id, @RequestBody Movie m) {
//        return ResponseEntity.ok(movie.updateMovie(id, m));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok(movie.deleteMovie(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok(movie.deleteAll());
    }
}
