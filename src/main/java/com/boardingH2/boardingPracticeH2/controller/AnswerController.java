package com.boardingH2.boardingPracticeH2.controller;

import com.boardingH2.boardingPracticeH2.controller.form.AnswerForm;
import com.boardingH2.boardingPracticeH2.entity.Answer;
import com.boardingH2.boardingPracticeH2.entity.Question;
import com.boardingH2.boardingPracticeH2.service.AnswerService;
import com.boardingH2.boardingPracticeH2.service.QuestionService;
import com.boardingH2.boardingPracticeH2.user.SiteUser;
import com.boardingH2.boardingPracticeH2.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createAnswer(@Validated @ModelAttribute AnswerForm answerForm, BindingResult bindingResult,
                               @PathVariable Integer id, Model model, Principal principal) {

        Question q = questionService.findById(id);
        SiteUser siteUser = userService.getUser(principal.getName());
        // 답변은 무슨 질문에 대한건지 알아야함!
        if(bindingResult.hasErrors()) {
            model.addAttribute("question", q);
            //model.addAttribute("answerForm", new AnswerForm());
            return "question/question_detail";
        }
        Answer a = answerService.createAnswer(q,answerForm.getSubject(),siteUser);
        log.info("answer is ={}", a);
        return String.format("redirect:/question/detail/%s",id );
    }


}
