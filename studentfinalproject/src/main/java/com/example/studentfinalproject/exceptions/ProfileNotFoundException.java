package com.example.studentfinalproject.exceptions;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(Long id) {
        super("Profile with id " + id + " doesn't exists!");
    }
}
