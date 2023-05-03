package com.boardingH2.boardingPracticeH2.repository;

import com.boardingH2.boardingPracticeH2.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);

    // 특정 문자열이 들어있는지 확인!
    List<Question> findBySubjectLike(String subject);

    // pageable을 입력받아서 Page<Question>타입의 객체를 리턴!
    Page<Question> findAll(Pageable pageable);

}
