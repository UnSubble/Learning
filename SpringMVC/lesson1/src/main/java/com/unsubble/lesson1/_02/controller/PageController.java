package com.unsubble.lesson1._02.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class PageController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ModelAndView modelAndView = new ModelAndView("page2");
        modelAndView.addObject("message", "my message");
        return modelAndView;
    }
}
