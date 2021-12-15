package currency_conversion.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class CurrencyConversion {
    @GetMapping("")
    public String currencyConversion() {

        return "currency_conversion";
    }

    @PostMapping("/currency")
    public String calculator(@RequestParam(name = "usd")  int usd ,Model model){
        int result = usd*23000;
        model.addAttribute("result",result);
        return "currency_conversion";
    }

}



