package furama.furama.controller;

import furama.furama.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/home")
    public String home(Model model,  Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "furama/home";
    }
    @GetMapping(value = {"/","/login"})
    public String loginPage() {
        return "furama/login";
    }


    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messenger","Bạn đã đăng xuất thành công");
        return "redirect:/login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> Bạn không có quyền nhé :v!";
            model.addAttribute("message", message);

        }

        return "furama/403Page";
    }

}