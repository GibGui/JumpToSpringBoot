package com.back.jumptospringboot;

import com.back.jumptospringboot.domain.answer.Answer;
import com.back.jumptospringboot.domain.answer.AnswerRepository;
import com.back.jumptospringboot.domain.question.Question;
import com.back.jumptospringboot.domain.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
//@RequiredArgsConstructor
class JumpToSpringBootApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);// 질문 2번 row꺼내옴
        assertTrue(oq.isPresent()); // 옵셔널이라 진짜 안에값있냐? 봄
        Question q = oq.get(); // 있으면 껍질 까서넣어줌

        List<Answer> answerList = q.getAnswerlist();// oneToMany로 연관지은 앤서어레이리스트가져옴,2번째 질문row에 해당하는.


        assertEquals(1, answerList.size());//전체 어레이 사이즈로 진짜 있나 판별
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());//어레이리스트0번째 컨텐츠 가져온게 ~생성됩니다인지 판별
    }



}
