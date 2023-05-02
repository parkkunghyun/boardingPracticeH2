package com.boardingH2.boardingPracticeH2.service;

import com.boardingH2.boardingPracticeH2.entity.Answer;
import com.boardingH2.boardingPracticeH2.entity.Question;
import com.boardingH2.boardingPracticeH2.repository.AnswerRepository;
import com.boardingH2.boardingPracticeH2.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Answer createAnswer(Question q, String subject) {
        Answer a = new Answer();
        a.setSubject(subject);
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        Answer savedA = answerRepository.save(a);
        return savedA;
    }


}
