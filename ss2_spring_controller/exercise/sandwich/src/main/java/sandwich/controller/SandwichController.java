package sandwich.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class SandwichController {


    @PostMapping(value = "/sandwich")
    public String list(@RequestParam("listCheckBox") String[] listCheckBox,
                       Model model, RedirectAttributes redirectAttributes) {

        model.addAttribute("listCheckBox", listCheckBox);
        return "list";
//        redirectAttributes.addFlashAttribute("listCheckBox",listCheckBox);
//        return "redirect:/list";

    }
}
