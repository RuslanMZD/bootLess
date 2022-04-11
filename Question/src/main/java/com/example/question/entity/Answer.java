package com.example.question.entity;

import com.example.question.dto.AnswerDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Answers")
// Из пакета ламбо позволяют не генерить всё что снизу
@Getter
@EqualsAndHashCode
@Setter
@ToString
@RequiredArgsConstructor

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private Long id;
    @Column(name = "ans_name")
    private String name;
    @ManyToOne
    @JoinColumn(name="ans_que_id",updatable = false,insertable = false)
    @ToString.Exclude  // Исключить из ToString т.к иначе будет эксепшен из-за свзяи с Question
    private Question question;


}
