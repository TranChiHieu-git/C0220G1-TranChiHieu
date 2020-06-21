package com.codegym.controller;

import com.codegym.model.ModelLang;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LangController {
    @GetMapping("/")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("credential", new ModelLang());
        return modelAndView;
    }

    @PostMapping("/login")
    ModelAndView login(@ModelAttribute("credential") ModelLang credential) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("user", credential);
        return modelAndView;
    }

}
