package com.example.question.controller;


import com.example.question.dto.ProfileDto;
import com.example.question.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor // lomboc создаст конструктор со всеми парам-ми
public class ProfileController {

    private ProfileService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<EntityModel<ProfileDto>> getProfileById(@PathVariable Long id){
    EntityModel<ProfileDto> byId =service.getById(id);
        return  ResponseEntity.ok().body(byId);
    }

    @DeleteMapping ("/delete/{id}")
    public ProfileDto deleteProfileById(@PathVariable Long id){
       return service.deleteProfileById(id);
    }
    @PostMapping ("/add")
    public ResponseEntity<String> addProfile(@RequestBody ProfileDto profileDto){
       service.addNewProfile(profileDto);
        return ResponseEntity.ok().body("Add is success");
    }

    @PutMapping("/update/{id}?{name}")
    public ProfileDto updateProfile(@PathVariable Long id, @PathVariable String name){
       return service.updateProfile(id,name);
    }


}
