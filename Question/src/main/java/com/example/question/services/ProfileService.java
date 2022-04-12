package com.example.question.services;

import com.example.question.controller.ProfileController;
import com.example.question.dto.ProfileDto;
import com.example.question.entity.Profile;
import com.example.question.exception.NotFoundProfileException;
import com.example.question.hateoas.ProfileAssembler;
import com.example.question.repositories.ProfileRepository;
import com.example.question.util.Mapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    private Mapper mapper;
    private ProfileAssembler profileAssembler;

    public ProfileService(ProfileRepository profileRepository, Mapper mapper,ProfileAssembler profileAssembler) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
        this.profileAssembler = profileAssembler;
    }

    public EntityModel<ProfileDto> getById(Long id){
//          Optional <Profile> byId=profileRepository.findById(id);  //на find начинаются hibernate методы , а на get jpa
//            if(byId.isPresent()){
//                Profile profile = byId.get();
//            }

    Profile profile =  profileRepository.findById(id).orElseThrow(()->new NotFoundProfileException(id)); // Если такого id нет то orElseThrow создаст симплер который создаст объект


        ProfileDto profileDto= mapper.mapper(profile, ProfileDto.class);
        mapper.mapper(profileDto,Profile.class); // почему тут обратно?

        return profileAssembler.toModel(profileDto);

    }

    public ProfileDto deleteProfileById(Long id){
        Profile profile = profileRepository.findById(id).orElseThrow(()->new NotFoundProfileException(id));
        profileRepository.deleteById(profile.getId());
        ProfileDto profileDto = mapper.mapper(profile,ProfileDto.class);
        mapper.mapper(profileDto,Profile.class);
        return profileDto;
    }



    public void addNewProfile(ProfileDto profileDto){
     Profile profile = mapper.mapper(profileDto,Profile.class);
     profileRepository.save(profile);

    }

    public ProfileDto updateProfile(Long id, String name){
        Profile profile = profileRepository.findById(id).orElseThrow(()->new NotFoundProfileException(id));
        profile.setName(name);
        profileRepository.save(profile);
        ProfileDto profileDto = mapper.mapper(profile,ProfileDto.class);
        mapper.mapper(profileDto,Profile.class);
        return profileDto;

    }





}
