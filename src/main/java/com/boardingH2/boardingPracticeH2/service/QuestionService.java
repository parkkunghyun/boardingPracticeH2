package com.boardingH2.boardingPracticeH2.service;

import com.boardingH2.boardingPracticeH2.entity.Question;
import com.boardingH2.boardingPracticeH2.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);
    }

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public Question findById(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        }
        return null;
    }
}
