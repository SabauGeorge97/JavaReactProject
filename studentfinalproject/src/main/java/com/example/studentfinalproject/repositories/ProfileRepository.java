package com.example.studentfinalproject.repositories;

import com.example.studentfinalproject.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
