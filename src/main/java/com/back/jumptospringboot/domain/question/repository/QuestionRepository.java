package com.back.jumptospringboot.domain.question.repository;

import com.back.jumptospringboot.domain.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    Question findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
}
