package com.example.question.controller;


import com.example.question.dto.ProfileDto;
import com.example.question.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor // lomboc создаст конструктор со всеми парам-ми
public class ProfileController {

    private ProfileService service;

    @GetMapping("/get/{id}")
    public ProfileDto getProfileById(@PathVariable Long id){

        return service.getById(id);
    }

    @GetMapping("/add/{name}")
    public void addProfile(@PathVariable String name){
        service.addProfile(name);
    }


}
