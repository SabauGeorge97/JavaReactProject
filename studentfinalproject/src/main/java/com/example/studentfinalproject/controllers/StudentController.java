package com.example.studentfinalproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.studentfinalproject.exceptions.StudentNotFoundException;
import com.example.studentfinalproject.model.Student;
import com.example.studentfinalproject.repositories.StudentRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //get all students
    @GetMapping("/students")
    List<Student> all() {
        return studentRepository.findAll();
    }

    //get only 1 student by Id
    @GetMapping("/students/{id}")
    Student one(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    //create a new Student
    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    //update a student
    @PutMapping("/students/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student-> {
                    student.setName(newStudent.getName());
                    student.setEmail(newStudent.getEmail());
                    student.setPhone(newStudent.getPhone());
                    student.setAddress(newStudent.getAddress());
                    student.setProfile(newStudent.getProfile());
                    return studentRepository.save(student);
                })
                .orElseGet(()->{
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    //delete a student
    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}