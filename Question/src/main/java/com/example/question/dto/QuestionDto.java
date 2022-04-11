package com.example.question.dto;

import lombok.*;

import java.util.List;



@Getter
@EqualsAndHashCode
@Setter
@ToString
@RequiredArgsConstructor
public class QuestionDto {


    private Long id;

    private String name;
    private Long numOfCorr;

    private List<AnswerDto> answers;


    private ProfileDto profile;


    private LevelDto level;
}
