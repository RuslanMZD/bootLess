package com.example.question.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Profiles")
@Getter
@EqualsAndHashCode
@Setter
@ToString
@RequiredArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id")
    private Long id;
    @Column(name="prof_name")
    private String name;
    @OneToMany(mappedBy = "profile")
    private List<Question> questions;
}
