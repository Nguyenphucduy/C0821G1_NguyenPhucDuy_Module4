package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping(value = {"/list",""})
    public String listPage(Model model) {
        model.addAttribute("students", iStudentService.getAll());
        return "student/list";
    }

    @GetMapping(value = "detail/{id}/{name}")
    public String getStudentDetail(@PathVariable(name = "id")Integer id,
                                   @PathVariable(name = "name")String name, Model model) {
        System.out.println(name);
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping(value = "detail")
    public String getStudentDetailRequestParam(@RequestParam(name = "id")Integer id,
                                               Model model, @RequestParam(name = "name")String name) {
        System.out.println(name);
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping(value = "create")
    public String getPageCreate() {
        return "student/create";
    }

    @PostMapping(value = "create")
    public String createStudent(@RequestParam(name = "id")Integer id, @RequestParam("name")String name,
                                @RequestParam("dateOfBirth")String dateOfBirth,
                                @RequestParam("gender")Integer gender, @RequestParam("grade")Double grade,
                                RedirectAttributes redirectAttributes) {
        Student student = new Student(id,name,dateOfBirth,gender,grade);
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg","Create student successfully!");
        return "redirect:/student/list";
    }
}
