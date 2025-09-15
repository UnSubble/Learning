package com.unsubble.lesson1._01.controller;

import com.unsubble.lesson1._01.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class SpringHelloController {

    private HelloService service;

    @Autowired
    public SpringHelloController(HelloService service) {
        this.service = service;
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public String printMessage(ModelMap modelMap) {

        String message = service.createMessage();

        modelMap.addAttribute("message", message);

        return "hello";
    }

    @RequestMapping(value = "/print", method = RequestMethod.PUT)
    public String putMessage(Model model) {

        String message = service.createMessage() + "2";

        model.addAttribute("message2", message);

        return "hello2";
    }

    @RequestMapping(value = "/print2", method = RequestMethod.GET)
    public String printMessage(@RequestParam(value = "show" /*, required = false
                            // zorunlu olursa parametresiz page açılmaz */) String paramValue, ModelMap modelMap) {

        String message = "not showed";

        if (paramValue.equalsIgnoreCase("true"))
            message = "showed";

        modelMap.addAttribute("message", message);

        return "hello";
    }


    // url: https://localhost:8080/lesson1_war_exploded/hello/print3/list=a,b;first=true;second=details
    @RequestMapping(value = "/print3/{matrixVariables}", method = RequestMethod.GET)
    public String matrixMessage(@MatrixVariable(pathVar = "matrixVariables", name = "list") List<String> list,
                                @MatrixVariable(pathVar = "matrixVariables", name = "first") String value,
                                @MatrixVariable(pathVar = "matrixVariables", name = "second") String value2,
                                ModelMap modelMap) { // varsayılan olarak matrix annotation kapalıdır.

        String message = "not showed";

        if (value.equalsIgnoreCase("true"))
            message = "showed";

        message += value2;

        System.out.println(list);

        modelMap.addAttribute("message", message);

        return "hello";
    }
}