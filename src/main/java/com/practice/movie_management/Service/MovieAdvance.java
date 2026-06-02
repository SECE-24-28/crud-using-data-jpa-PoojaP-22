package com.practice.movie_management.Service;

import com.practice.movie_management.Entity.Movie;
import com.practice.movie_management.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieAdvance {

    @Autowired
    private MovieRepo repo;

    public List<Movie> getAll(){
        return repo.findAll();
    }

    public Movie getId(int id){
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Movie Not Found"));
    }

    public Movie addMovie(Movie movie){
        return repo.save(movie); //this automatically saves data into DB
    }

    public Movie updateMovie(Movie movie){
        return repo.save(movie);
    }

    public String deleteMovie(int id){
        repo.deleteById(id);
        return "Movie Deleted";
    }

    public String deleteAll() {
        repo.deleteAll();
        return "DataBase Cleared";
    }
}
