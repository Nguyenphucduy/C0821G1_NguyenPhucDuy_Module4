package sandwich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sandwich.service.IServiceSandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ControllerSandwich {
    //    @Autowired
//    IServiceSandwich iServiceSandwich;

    
//    @GetMapping("")
//    public String view() {
//        return "view";
//    }

    @PostMapping("/sandwich")
    public String list(@RequestParam("lettuce") Optional<String> lettuce, @RequestParam("tomato") Optional<String>tomato,
                       @RequestParam("mustard") Optional<String> mustard, @RequestParam("sprouts") Optional<String> sprouts,
                       Model model) {

        List<String> stringList = new ArrayList<>();


        if (lettuce.isPresent()) {
            stringList.add("Yes");
        } else {
            stringList.add("Not");
        }

        //----------------------------------------------


        if (tomato.isPresent()) {
            stringList.add("Yes");
        } else {
            stringList.add("Not");
        }
//-----------------------------------------

        if (mustard.isPresent()) {
            stringList.add("Yes");
        } else {
            stringList.add("Not");
        }
        //--------------------------------------------

        if (sprouts.isPresent()) {
            stringList.add("Yes");
        } else {
            stringList.add("Not");
        }

        model.addAttribute("stringList", stringList);

        return "list";
    }
}
