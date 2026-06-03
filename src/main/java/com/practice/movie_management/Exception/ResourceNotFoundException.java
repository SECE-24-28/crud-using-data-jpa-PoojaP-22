package com.practice.movie_management.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resource,String field,String path){
        super(String.format(
               "%s not found with %s: %s",
                resource,
                field,
                path
        ));
    }
}
