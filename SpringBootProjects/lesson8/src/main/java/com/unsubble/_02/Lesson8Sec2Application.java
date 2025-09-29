package com.unsubble._02;

import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication(scanBasePackages = "com.unsubble")
@Controller
public class Lesson8Sec2Application {

    @GetMapping("/getStudentPage")
    public String getStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "studentPage";
    }

    @PostMapping("/validateStudent")
    public String validateStudent(@Valid @ModelAttribute("student") Student student,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "studentPage";
        System.out.println(student);
        return "redirect:getStudentPage";
    }
}
