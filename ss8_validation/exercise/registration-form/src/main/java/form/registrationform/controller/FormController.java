package form.registrationform.controller;

import form.registrationform.dto.UserDTO;
import form.registrationform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FormController {
    @Autowired
    IUserService iUserService;
    @GetMapping(value = "/create")
    public String getPageCreate(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }

    @PostMapping(value = "/create_done")
    public String createUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult bindingResult, Model model) {

       new UserDTO().validate(userDTO,bindingResult);

        if(bindingResult.hasErrors()) {
            return "index";
        }else {
            iUserService.save(userDTO);
            return "result";
        }
    }
}
