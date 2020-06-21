package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CalService;
import service.CalServiceInterface;


@Controller
public class CalcullatorController {
    CalService calService = new CalService();
    @GetMapping("/calculator")
    public String calculator(@RequestParam String num1, String num2, String operand, Model model) {
        switch (operand) {
            case "Addition(+)":
                model.addAttribute("result", calService.add(Double.parseDouble(num1), Double.parseDouble(num2)));
                break;
            case "Subtraction(-)":
                model.addAttribute("result", calService.sub(Double.parseDouble(num1) , Double.parseDouble(num2)));
                break;
            case "Multiplication(x)":
                model.addAttribute("result", calService.mul(Double.parseDouble(num1) , Double.parseDouble(num2)));
                break;
            case "Division(:)":
                model.addAttribute("result", calService.div(Double.parseDouble(num1) , Double.parseDouble(num2)));
                break;
        }
        return "index";
    }
}
