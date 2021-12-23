package com.codegym.demo_c0821g1_2.controller;

import com.codegym.demo_c0821g1_2.model.Student;
import com.codegym.demo_c0821g1_2.service.IClassService;
import com.codegym.demo_c0821g1_2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private IClassService iClassService;

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
//    @GetMapping(value = {"/list", ""})
//    public ModelAndView listPage() {
//        return new ModelAndView("student/list_student","students", iStudentService.getAll());
//    }



    @GetMapping(value = "/detail/{id}")
    public String getStudentDetail(@PathVariable(name = "id") Integer id, Model model) {
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail_student";
    }

    @GetMapping(value = "/detail")
    public String getStudentDetailRequestParam(@RequestParam(name = "id") Integer id,
                                               Model model) {
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail_student";
    }

    @GetMapping(value = "/create")
    public String getPageCreate(Model model) {
        String[] genders = {"Nam","Nữ","Khác"};
        model.addAttribute("genders",genders);
        model.addAttribute("classes", iClassService.findAll());
        model.addAttribute("student", new Student());
        return "student/create_student";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Create student successfully!");
        return "redirect:/student/list";
    }

//    @GetMapping("search")
//    public String searchStudent(@RequestParam(name = "name")String name, Model model) {
//        List<Student> studentList= iStudentService.findByName(name);
//        model.addAttribute("students", studentList);
//        return "student/list_student";
//    }
    @GetMapping(value = {"/list", ""})
    public ModelAndView listPage(@RequestParam(value = "name", defaultValue = "")String name) {
        return new ModelAndView("student/list_student","students", iStudentService.findByName(name));
    }

    @GetMapping(value = "list-page")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        Sort sort = Sort.by("name").descending();
        Page<Student> studentPage = iStudentService.findAll(PageRequest.of(page,5,sort));
        model.addAttribute("studentPage", studentPage);
        return "student/list_page";
    }
}
