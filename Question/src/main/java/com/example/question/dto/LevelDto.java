package com.example.question.dto;

import lombok.*;

import java.util.List;


@Getter
@EqualsAndHashCode
@Setter
@ToString
@RequiredArgsConstructor
public class LevelDto {

    private Long id;

    private String name;

    private List<QuestionDto> questions;
}
