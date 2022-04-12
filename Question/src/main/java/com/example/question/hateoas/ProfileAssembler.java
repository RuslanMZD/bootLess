package com.example.question.hateoas;

import com.example.question.controller.ProfileController;
import com.example.question.dto.ProfileDto;
import com.example.question.entity.Profile;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProfileAssembler implements RepresentationModelAssembler<ProfileDto, EntityModel<ProfileDto>> {


    @Override
    public EntityModel<ProfileDto> toModel(ProfileDto entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ProfileController.class)
                        .updateProfile(
                                entity.getId(),
                                entity.getName())).
                        withRel("Update profile by id "+ HttpMethod.PUT),
                linkTo(methodOn(ProfileController.class).getProfileById(entity.getId())).withRel("Get profile by Id "+ HttpMethod.GET),
                linkTo(methodOn(ProfileController.class).deleteProfileById(entity.getId())).withRel("Delete by Id "+ HttpMethod.DELETE),
                linkTo(methodOn(ProfileController.class).addProfile(entity)).withRel("Add profile "+ HttpMethod.POST));
    }

    @Override
    public CollectionModel<EntityModel<ProfileDto>> toCollectionModel(Iterable<? extends ProfileDto> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
