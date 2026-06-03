package com.practice.movie_management.Service;

import com.practice.movie_management.Entity.Movie;
import com.practice.movie_management.Exception.ResourceNotFoundException;
import com.practice.movie_management.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieAdvance {

    @Autowired
    private MovieRepo repo;

    //GET Movie List
    public List<Movie> getAll(){
        return repo.findAll();
    }

    //GET Movie by id
    public Movie getId(int id){
        return repo.findById(id)
                   .orElseThrow(() ->
                    new ResourceNotFoundException(
                "Movie",
                "id",
                String.valueOf(id)
        ));
    }

    //POST single Movie
    public Movie addMovie(Movie movie){
        return repo.save(movie);
    }

    //POST Movie List
    public List<Movie> addMovieAll(List<Movie> movie){
        return repo.saveAll(movie); //this automatically saves data into DB
    }

    //PUT Movie
    public Movie updateMovie(Movie movie){
        return repo.save(movie);
    }

    //DELETE Movie by id
    public String deleteMovie(int id){
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Movie",
                    "id",
                    String.valueOf(id)
            );
        }
        repo.deleteById(id);
        return "Movie Deleted";
    }

    //DELETE all Movie
    public String deleteAll() {
        repo.deleteAll();
        return "DataBase Cleared";
    }

    //GET Movie by passing params
    public List<Movie> getMoviesByTitleAndRating(String title, double rating) {
        return repo.findByTitleAndRating(title, rating);
    }

    public List<Movie> getMovieByRating(double rating){
        return repo.findByRating(rating);
    }

    public List<Movie> getMovieByTandR(String title, double rating) {
        return repo.findBy(title,rating);

    }
}
