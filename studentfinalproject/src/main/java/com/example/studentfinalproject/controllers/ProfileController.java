package com.example.studentfinalproject.controllers;

import com.example.studentfinalproject.exceptions.ProfileNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.studentfinalproject.model.Profile;
import com.example.studentfinalproject.repositories.ProfileRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    //get all profiles
    @GetMapping("/profiles")
    List<Profile> all() {
        return profileRepository.findAll();
    }

    //get only 1 profile by Id
    @GetMapping("/profiles/{id}")
    Profile one(@PathVariable Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
    }

    //create a new Profile
    @PostMapping("/profiles")
    Profile newProfile(@RequestBody Profile newProfile) {
        return profileRepository.save(newProfile);
    }

    //update a profile
    @PutMapping("/profiles/{id}")
    Profile updateProfile(@RequestBody Profile newProfile, @PathVariable Long id) {
        return profileRepository.findById(id)
                .map(profile-> {
                    profile.setName(newProfile.getName());
                    return profileRepository.save(profile);
                })
                .orElseGet(()->{
                    newProfile.setId(id);
                    return profileRepository.save(newProfile);
                });
    }

    //delete a profile
    @DeleteMapping("/profiles/{id}")
    void deleteProfile(@PathVariable Long id) {
        profileRepository.deleteById(id);
    }
}
