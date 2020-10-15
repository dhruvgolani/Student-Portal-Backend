package com.studentportalbackend.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String collegeId){
        super(String.format("User with College ID %s already exists.", collegeId));
    }
}
