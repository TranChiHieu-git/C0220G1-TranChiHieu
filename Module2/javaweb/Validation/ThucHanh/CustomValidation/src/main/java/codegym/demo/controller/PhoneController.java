package codegym.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import codegym.demo.model.PhoneNumber;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("phonemunber", new PhoneNumber());
        return "/views/index";
    }

    @PostMapping("/result")
    public String checkValidation(@Valid @ModelAttribute("phonemunber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/views/index";
        } else {
            model.addAttribute("phoneNumber", phoneNumber.getNumber());
            return "/views/result";
        }
    }
}
