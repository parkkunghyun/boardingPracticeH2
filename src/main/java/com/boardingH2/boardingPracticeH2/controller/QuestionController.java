package com.boardingH2.boardingPracticeH2.controller;

import com.boardingH2.boardingPracticeH2.controller.form.AnswerForm;
import com.boardingH2.boardingPracticeH2.controller.form.QuestionForm;
import com.boardingH2.boardingPracticeH2.entity.Question;
import com.boardingH2.boardingPracticeH2.repository.QuestionRepository;
import com.boardingH2.boardingPracticeH2.service.QuestionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/question")
@Slf4j
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question/question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Question q = questionService.findById(id);
        if(q== null) {
            log.info("잘못된 아이디를 찾고 있음!");
        }
        model.addAttribute("question", q);
        model.addAttribute("answerForm", new AnswerForm());
        return "question/question_detail";
    }

    @GetMapping("/create")
    public String questionForm(Model model){
        model.addAttribute("questionForm", new QuestionForm());
        return "question/question_form";
    }

    @PostMapping("/create")
    public String createQuestion( @Validated @ModelAttribute QuestionForm questionForm,
                                  BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "question/question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());

        return "redirect:/question/list";
    }
}
