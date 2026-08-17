package com.back.jumptospringboot.domain.question.entity;

import com.back.jumptospringboot.domain.answer.entity.Answer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;


    @OneToMany(mappedBy = "question",
            cascade = CascadeType.REMOVE

            , fetch = FetchType.LAZY)
    List<Answer> answerList = new ArrayList<>();
}
