package dictionary.controller;

import dictionary.bean.Dictionary;
import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
//@RequestMapping("dictionary")
public class DictionaryController {
    @Autowired
//    @Qualifier("DictionaryService")
    private IDictionaryService iDictionaryService;


    @GetMapping("")
    public String home() {

        return "view";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam(name = "word")  String word , Model model){
        String result = "Không tìm thấy từ của bạn";
        for (Dictionary dictionary : iDictionaryService.getAll()){
            if (dictionary.getWord().equals(word)) {
                result = dictionary.getMeans();
                break;
            }
        }

        model.addAttribute("result",result);
        return "view";
    }
}
