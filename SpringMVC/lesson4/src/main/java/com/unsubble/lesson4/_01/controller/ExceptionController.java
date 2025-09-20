package com.unsubble.lesson4._01.controller;

import com.unsubble.lesson4._01.model.ProductException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    // kullanmak için SimpleMappingExceptionResolver bean'ini devre dışı bırakmaya gerek yok.
    // çünkü bu bean daha öncelikli.
    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormat(NumberFormatException ex, Model model) {
        model.addAttribute("exception", ex);
        return "numberFormat";
    }

    @ExceptionHandler(ProductException.class)
    public String handleProductEx(ProductException ex, Model model) {
        model.addAttribute("exception", ex);
        return "productEx";
    }
}
