package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringController {

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "World");

        return "hello";
    }


}
