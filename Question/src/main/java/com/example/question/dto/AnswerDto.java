package com.example.question.dto;

import lombok.*;


@Getter
@EqualsAndHashCode
@Setter
@ToString
@RequiredArgsConstructor

public class AnswerDto {


    private Long id;

    private String name;

    @ToString.Exclude  // Исключить из ToString т.к иначе будет эксепшен из-за свзяи с Question
    private QuestionDto question;





}
