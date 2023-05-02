package com.boardingH2.boardingPracticeH2.controller.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "질문 내용은 필수 입니다!")
    private String subject;
}
