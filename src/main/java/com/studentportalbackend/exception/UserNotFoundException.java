package com.studentportalbackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String collegeId){
        super(String.format("Sorry user with College ID %s not found.", collegeId));
    }
}
