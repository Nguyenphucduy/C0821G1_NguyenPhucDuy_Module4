package com.codegym.controller;


import com.codegym.entity.ConfigEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/config")
public class ConfigEmailController {

    @GetMapping("email")
    public String configEmail(Model model){
        String[] language = {"English","Vietnamese","Japanese","Chinese"};
        Integer[] pageSize = {5,10,15,25,50,100};
        model.addAttribute("language",language);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("configEmail",new ConfigEmail());
        return "setting_email";
    }

    @PostMapping("info_config")
    public String updateEmail(@ModelAttribute("configEmail") ConfigEmail configEmail,Model model){
        model.addAttribute("configEmail",configEmail);
        return "info_config";
    }


}


