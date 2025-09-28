package com.unsubble._01;

import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication(scanBasePackages = "com.unsubble")
@Controller
public class Lesson8Sec1Application {

    @RequestMapping(value = "/getFormPage", method = RequestMethod.GET)
    public String getFormPage(Model model) {
        model.addAttribute("person", new Person());
        return "formPage";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(@Valid @ModelAttribute("person") Person person,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "formPage";
        System.out.println(person.getName());
        model.addAttribute("person", person);
        return "validPage";
    }
}
