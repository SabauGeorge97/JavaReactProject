package com.example.studentfinalproject.service;

import com.example.studentfinalproject.model.Profile;
import com.example.studentfinalproject.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> list() {
        return profileRepository.findAll();
    }
}
