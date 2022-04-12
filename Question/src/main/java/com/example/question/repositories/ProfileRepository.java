package com.example.question.repositories;

import com.example.question.entity.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Long> {

  //  @Override
 //   @Query(value = "select Profile where")  //если переопределяем метод из  JpaRepository
   // Optional<Profile> findById(Long aLong);

    //    Optional<Profile> findByIdAndName(Long id,String name); // Свой запрос IDE подставляет имя запроса и от этого JPA понимает что нужно делать


    @Override
    @EntityGraph(value = "all-fields")
    Optional<Profile> findById(Long aLong);
}
