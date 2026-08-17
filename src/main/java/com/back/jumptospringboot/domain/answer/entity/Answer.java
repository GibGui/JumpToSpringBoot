package com.back.jumptospringboot.domain.answer.entity;


import com.back.jumptospringboot.domain.question.entity.Question;
import com.back.jumptospringboot.user.SiteUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String content;


    private LocalDateTime createDate;
    private LocalDateTime modifyDate;


    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Answer(String content, Question question){
        this.question = question;
        this.content = content;
        this.setCreateDate(LocalDateTime.now());
    }

    @ManyToOne
    private SiteUser author;

}
