package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//Áp dụng cho toàn bộ các URL muốn vào controller này
@RequestMapping("student")
public class StudentController {

    //Sử dụng interface
    @Autowired //Annotation
    //Sử dụng @Qualifier trong trường hợp 1 interface có nhiều class triển khai.
    @Qualifier("studentService")
    private IStudentService iStudentService;

    //Sử dụng Construstor
//    @Autowired
//    public StudentController(StudentService studentService){
//        this.iStudentService = studentService;
//    }

    //Sử dụng setter -> tìm hiểu thêm.

//Sử dụng model để gửi dữ liệu
//    @GetMapping(value = {"/list", ""})
//    public String listPage(Model model) {
//        model.addAttribute("students", iStudentService.getAll());
//        return "student/list";
//    }

    //Sử dụng ModelAndView.
    @GetMapping(value = {"/list", ""})
    public ModelAndView listPage() {
        return new ModelAndView("student/list_student","students", iStudentService.getAll());
    }



    @GetMapping(value = "detail/{id}")
    public String getStudentDetail(@PathVariable(name = "id") Integer id, Model model) {
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail_student";
    }

    @GetMapping(value = "detail")
    public String getStudentDetailRequestParam(@RequestParam(name = "id") Integer id,
                                               Model model) {
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail_student";
    }

    @GetMapping(value = "create")
    public String getPageCreate(Model model) {
        String[] genders = {"Nam","Nữ","Khác"};
        model.addAttribute("genders",genders);
        model.addAttribute("student", new Student());
        return "student/create_student";
    }

    @PostMapping(value = "create")
    public String createStudent(@ModelAttribute("student")Student student,RedirectAttributes redirectAttributes) {
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Create student successfully!");
        return "redirect:/student/list";
    }
}
