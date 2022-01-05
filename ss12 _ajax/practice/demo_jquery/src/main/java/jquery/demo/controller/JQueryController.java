package jquery.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JQueryController {
    @GetMapping("hide")
    public String hide() {
        return "hide_show";
    }
    @GetMapping("animate")
    public String animate() {
        return "animate";
    }
}
