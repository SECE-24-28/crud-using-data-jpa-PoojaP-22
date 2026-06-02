//package com.practice.movie_management.Service;
//
//import com.practice.movie_management.Entity.Movie;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.http.HttpStatus.BAD_REQUEST;
//
//@Service
//public class MovieImplements implements MovieService{
//    public static List<Movie> mList = new ArrayList<>();
//
//    static{
//        mList.add(new Movie(11,"OK Kanmanni","xxx",4.5));
//        mList.add(new Movie(12,"Harry Potter","yyy",7.5));
//    }
//
//    @Override
//    public List<Movie> getAll(){
//        return mList;
//    }
//
//    @Override
//    public Movie getId(int id){
//        for(Movie m : mList){
//            if(m.getId() == id){
//                return m;
//            }
//        }
//        return BAD_REQUEST;
//    }
//
//    @Override
//    public Movie addMovie(Movie m){
//        mList.add(m);
//        return m;
//    }
//
//    @Override
//    public Movie updateMovie(int id,Movie newMovie){
//        for(Movie m : mList){
//            if(m.getId() == id){
//                m.setTitle(newMovie.getTitle());
//                m.setDirector(newMovie.getDirector());
//                m.setRating(newMovie.getRating());
//                return m;
//            }
//        }
//        return BAD_REQUEST;
//    }
//
//    @Override
//    public String deleteMovie(int id){
//        Movie found = null;
//        for(Movie m : mList){
//            if(m.getId() == id){
//                found = m;
//                break;
//            }
//        }
//        if(found != null){
//            mList.remove(found);
//            return "Movie deleted Successfully";
//        }
//        return BAD_REQUEST;
//    }
//}
