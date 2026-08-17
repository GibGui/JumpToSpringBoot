package com.back.jumptospringboot.domain.answer.repository;

import com.back.jumptospringboot.domain.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
