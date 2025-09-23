package com.unsubble.lesson7._01.controller;

import com.unsubble.lesson7._01.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson7")
@Controller
public class Lesson7Sec1Application {

    @GetMapping("/getTemplate")
    public String getTemplate(Model model) {
        model.addAttribute("theDate", new Date());
        return "firstTemplate";
    }

    @GetMapping("/getHelloForm")
    public ModelAndView getHelloForm(ModelAndView modelAndView) {
        modelAndView.setViewName("helloForm");
        modelAndView.addObject("nname", "");
        return modelAndView;
    }

    @PostMapping("/getHelloForm")
    public String postHelloForm(@ModelAttribute("name") String name, Model model) {
        model.addAttribute("nname", name);
        return "helloForm";
    }

    @RequestMapping("/processForm")
    public void lets(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/getHelloForm");
        request.setAttribute("secret", "123");
        dispatcher.forward(request, response);
    }

    @GetMapping("/getFormWithObj")
    public String getFormWithObj(Model model) {
        model.addAttribute("student", new Student());
        return "helloFormWithObj";
    }

    @PostMapping("/getFormWithObj")
    public String postFormWithObj(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "helloFormWithObj";
    }
}
