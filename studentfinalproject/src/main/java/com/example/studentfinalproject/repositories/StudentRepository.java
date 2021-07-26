package com.example.studentfinalproject.repositories;
import com.example.studentfinalproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}


