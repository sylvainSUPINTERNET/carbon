package com.carbon.apicarbon.controllers;

import com.carbon.apicarbon.repositories.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profiles")
public class ProfileController {

    @Autowired
    ProfileRepository profileRepository;
    public ProfileController(){}


    @GetMapping("/random")
    public ResponseEntity<?> getRandomProfiles() {
        return ResponseEntity.ok().body(this.profileRepository.findRandomProfiles());
    }

    
}
