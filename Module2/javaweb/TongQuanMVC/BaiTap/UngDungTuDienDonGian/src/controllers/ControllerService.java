package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.DictionaryService;

@Controller
public class ControllerService {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/result")
    public ModelAndView result(@RequestParam ("word") String word){
        ModelAndView modelAndView=new ModelAndView("result");
        modelAndView.addObject("result",dictionaryService.findWord(word));
        return modelAndView;
    }
}
