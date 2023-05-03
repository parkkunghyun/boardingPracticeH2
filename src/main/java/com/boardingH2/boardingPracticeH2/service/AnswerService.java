package com.boardingH2.boardingPracticeH2.service;

import com.boardingH2.boardingPracticeH2.entity.Answer;
import com.boardingH2.boardingPracticeH2.entity.Question;
import com.boardingH2.boardingPracticeH2.repository.AnswerRepository;
import com.boardingH2.boardingPracticeH2.repository.QuestionRepository;
import com.boardingH2.boardingPracticeH2.user.SiteUser;
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

    public Answer createAnswer(Question q, String subject, SiteUser siteUser) {
        Answer a = new Answer();
        a.setSubject(subject);
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        a.setAuthor(siteUser); //글슨이
        Answer savedA = answerRepository.save(a);
        return savedA;
    }


}
