package com.back.jumptospringboot.domain.answer.service;

import com.back.jumptospringboot.domain.answer.entity.Answer;
import com.back.jumptospringboot.domain.answer.repository.AnswerRepository;
import com.back.jumptospringboot.domain.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;


    public void create(Question question, String content){

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(answer);

    }





}
