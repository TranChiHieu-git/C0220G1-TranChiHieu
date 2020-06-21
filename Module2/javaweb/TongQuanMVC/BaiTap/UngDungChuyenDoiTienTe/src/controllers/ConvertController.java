package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.CalculatorServices;

@Controller
public class ConvertController {
    @Autowired
    CalculatorServices calculatorServices;
    @GetMapping("/home")
    public  String home(){
        return "index";
    }

    @GetMapping("/convert")
    public ModelAndView convert(@RequestParam ("rate") double rate, @RequestParam ("money") double money) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("result",calculatorServices.Convert(rate,money));
        return modelAndView;
    }
}
