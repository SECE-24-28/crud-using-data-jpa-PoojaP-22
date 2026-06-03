package com.practice.movie_management.Controller;

import com.practice.movie_management.DTO.MovieDTO;
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
//    @GetMapping("/all")
//    public ResponseEntity<List<MovieDTO>> getAll() {
//        return ResponseEntity.ok(movie.getAll());
//    }

    //List Movie by id
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(movie.getMovie(id));
    }

    //Add new Movie List
//    @PostMapping("/list")
//    public ResponseEntity<List<MovieDTO>> addNew(@RequestBody List<@Valid MovieDTO> m) {
//        return ResponseEntity.ok(movie.addMovieAll(m));
//    }

    //Add new Movie
    @PostMapping("/new")
    public ResponseEntity<MovieDTO> addNewList(@Valid @RequestBody MovieDTO dto) {
        return ResponseEntity.ok(movie.addMovie(dto));
    }

    //Update Movie
//    @PutMapping("/update")
//    public ResponseEntity<MovieDTO> update(@Valid @RequestBody MovieDTO m) {
//        return ResponseEntity.ok(movie.updateMovie(m));
//    }

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
//    @GetMapping("/search")
//    public ResponseEntity<List<MovieDTO>> getMoviesByTitleAndRating(
//            @RequestParam String title,
//            @RequestParam double rating) {
//
//        return ResponseEntity.ok(
//                movie.getMoviesByTitleAndRating(title, rating)
//        );
//    }

//    @GetMapping("/{rating}")
//    public ResponseEntity<List<MovieDTO>> getMovieByRating(@PathVariable("rating") double rating){
//        return ResponseEntity.ok(movie.getMovieByRating(rating));
//    }
//
//    @PostMapping("/filter")
//    public List<MovieDTO> getMovieByTandR(@Valid
//            @Param("title") String title,
//            @Param("rating") double rating
//    ){
//        return movie.getMovieByTandR(title,rating);
//    }

}
