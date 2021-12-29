package com.codegym.demo_c0821g1.controller;

import com.codegym.demo_c0821g1.model.Student;
import com.codegym.demo_c0821g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping
public class HelloController {
    @Autowired
    private IStudentService iStudentService;
    //Scope bean

    //@GetMapping -> doGet, value <-> UrlPattern
    @GetMapping(value = "")
    public String helloPage(Model model) {
        model.addAttribute("name", "haiTT");

        //Trang mà bạn muốn hiển thị
        return "hello";
    }
// chạy lần đầu sẽ ra lỗi 400- phải vào controller để khởi tạo session  qua @ModelAttribute
    @GetMapping("/talk-list")
    //Lấy giá trị @SessionAttributes
    public String viewTalkList(@SessionAttribute("studentTalkList") List<Student> studentList, Model model) {
        model.addAttribute("studentTalkList", studentList);
        return "student/talk_list";
    }

}
