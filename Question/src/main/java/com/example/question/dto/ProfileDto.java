package com.example.question.dto;

import lombok.*;

import java.util.List;


@Getter
@EqualsAndHashCode
@Setter
@ToString
@RequiredArgsConstructor
public class ProfileDto {

    private Long id;

    private String name;

    private List<QuestionDto> questions;
}
