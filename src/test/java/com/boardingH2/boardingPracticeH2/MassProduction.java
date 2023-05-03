package com.boardingH2.boardingPracticeH2;

import com.boardingH2.boardingPracticeH2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MassProduction {
    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for(int i =0; i<300; i++) {
            String sb = String.format("테스트데이터입니다: [%03d]",i);
            String con = "내용무";
            questionService.create(sb,con);
        }
    }
}
