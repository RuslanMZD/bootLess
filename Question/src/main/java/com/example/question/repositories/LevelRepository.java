package com.example.question.repositories;

import com.example.question.entity.Level;
import com.example.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level,Long> {
}
