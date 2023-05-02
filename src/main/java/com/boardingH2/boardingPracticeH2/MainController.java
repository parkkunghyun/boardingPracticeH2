package com.boardingH2.boardingPracticeH2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
