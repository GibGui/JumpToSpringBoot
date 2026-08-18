package com.back.jumptospringboot.domain.answer.service;

import com.back.jumptospringboot.domain.answer.entity.Answer;
import com.back.jumptospringboot.domain.answer.repository.AnswerRepository;
import com.back.jumptospringboot.domain.question.entity.Question;
import com.back.jumptospringboot.global.DataNotFoundException;
import com.back.jumptospringboot.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;


    public Answer create(Question question, String content, SiteUser author){

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setContent(content);
        answer.setAuthor(author);
        answer.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Integer id){
        Optional<Answer> answer = this.answerRepository.findById(id);
        if(answer.isPresent()){
            return answer.get();
        }else{
            throw new DataNotFoundException("값이 존재하지 않습니다.");
        }

    }

    public void modify(Answer answer, String content){
        answer.setModifyDate(LocalDateTime.now());
        answer.setContent(content);
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer){
        this.answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser siteUser){
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }


}
