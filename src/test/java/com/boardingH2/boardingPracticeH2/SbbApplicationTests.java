package com.boardingH2.boardingPracticeH2;

import com.boardingH2.boardingPracticeH2.entity.Answer;
import com.boardingH2.boardingPracticeH2.entity.Question;
import com.boardingH2.boardingPracticeH2.repository.AnswerRepository;
import com.boardingH2.boardingPracticeH2.repository.QuestionRepository;
import com.boardingH2.boardingPracticeH2.service.QuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;



    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa() {
        Question q1 = new Question();
        q1.setSubject("제목1");
        q1.setContent("내용1");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("제목1");
        q2.setContent("내용1");
        q2.setCreateDate(LocalDateTime.now());
        questionRepository.save(q2);
    }

    @Test
    void findById(){
        List<Question> questionList = questionRepository.findAll();
        Assertions.assertThat(4).isEqualTo(questionList.size());
    }

    @Test
    void findBySubject() {
        Question q = questionRepository.findBySubject("제목1");
       Assertions.assertThat(1).isEqualTo(q.getId());
    }

    @Test
    void updateId(){
        Optional<Question> q = questionRepository.findById(4);
        if(q.isPresent()) {
            Question q1 =q.get();
            q1.setContent("내용4");
            q1.setSubject("질문4");
            questionRepository.save(q1);
        }
    }
    @Test
    void delete() {
        Optional<Question> oq = questionRepository.findById(4);
        if(oq.isPresent()) {
            Question q = oq.get();
            questionRepository.delete(q);
        }
        Assertions.assertThat(3).isEqualTo(questionRepository.count());
    }

    @Test
    void createAnswer() {
        Optional<Question> oq = questionRepository.findById(2);
        if(oq.isPresent()) {
           Question q = oq.get();

            Answer answer = new Answer();
            answer.setSubject("네 자동으로 생성됩니다!");
            answer.setQuestion(q);
            answer.setCreateDate(LocalDateTime.now());
            answerRepository.save(answer);
        }
    }

    @Test
    void findQuestionAnswer(){
        Optional<Answer> oa = answerRepository.findById(1);
        if(oa.isPresent()) {
            Answer answer = oa.get();
            Assertions.assertThat(2).isEqualTo(answer.getQuestion().getId());
        }
    }



}
