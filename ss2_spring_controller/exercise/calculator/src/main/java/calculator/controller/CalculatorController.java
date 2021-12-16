package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CalculatorController {

    @GetMapping("")
    public String view() {
        return "view";
    }


    @PostMapping("/calculator")
    public String calculator (@RequestParam("number1") Integer number1, @RequestParam("number2") Integer  number2, Model model,
                              @RequestParam("addition") Optional<String> addition, @RequestParam("subtraction")  Optional<String>  subtraction,
                              @RequestParam("multiplication") Optional<String> multiplication,@RequestParam ("division") Optional<String> division){
        Integer result = null;
       

        if (addition.isPresent()){
            result = number1 + number2;
        }else if (subtraction.isPresent()){
            result = number1 - number2;
        }else if (multiplication.isPresent()){
            result = number1 * number2;
        }else if (division.isPresent()){
            result = number1 / number2;
        }
        model.addAttribute("result", result);
        return "view";
    }

}
