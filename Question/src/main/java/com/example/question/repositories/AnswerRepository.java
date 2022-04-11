package com.example.question.repositories;

import com.example.question.entity.Answer;
import com.example.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
