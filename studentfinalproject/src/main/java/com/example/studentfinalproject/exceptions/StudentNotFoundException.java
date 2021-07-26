package com.example.studentfinalproject.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student with id " + id + " doesn't exists!");
    }
}
