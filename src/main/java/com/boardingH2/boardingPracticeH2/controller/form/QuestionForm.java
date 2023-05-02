package com.boardingH2.boardingPracticeH2.controller.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목 필수입니다.")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "내용 필수입니다.")
    private String content;
}
