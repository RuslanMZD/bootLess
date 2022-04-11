package com.example.question.services;

import com.example.question.dto.ProfileDto;
import com.example.question.entity.Profile;
import com.example.question.exception.NotFoundProfileException;
import com.example.question.repositories.ProfileRepository;
import com.example.question.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    private Mapper mapper;

    public ProfileService(ProfileRepository profileRepository, Mapper mapper) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
    }

    public ProfileDto getById(Long id){
//          Optional <Profile> byId=profileRepository.findById(id);  //на find начинаются hibernate методы , а на get jpa
//            if(byId.isPresent()){
//                Profile profile = byId.get();
//            }

    Profile profile =  profileRepository.findById(id).orElseThrow(()->new NotFoundProfileException(id)); // Если такого id нет то orElseThrow создаст симплер который создаст объект


        ProfileDto profileDto= mapper.mapper(profile, ProfileDto.class);
        mapper.mapper(profileDto,Profile.class); // почему тут обратно?
        System.out.println("Oke");
        return profileDto;

    }

    public void addProfile(String name){
        Profile profile = new Profile();
        profile.setName(name);

        profileRepository.save(profile);


    }



}
