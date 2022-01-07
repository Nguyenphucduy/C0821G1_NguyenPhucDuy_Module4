package com.codegym.demo_c0821g1.controller;

import com.codegym.demo_c0821g1.dto.StudentDTO;
import com.codegym.demo_c0821g1.model.Student;
import com.codegym.demo_c0821g1.service.IClassService;
import com.codegym.demo_c0821g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Controller
// Khai báo session
@SessionAttributes("studentTalkList")
//Áp dụng cho toàn bộ các URL muốn vào controller này
@RequestMapping("student")
public class StudentController {
// khởi tạo session
    @ModelAttribute("studentTalkList")
    public List<Student> createStudentTalkList() {
        return new ArrayList<>();
    }

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

    @GetMapping("/addTalkList/{id}")
    //Tương tác session
    public String addToTalkList(@PathVariable("id")Integer id, @ModelAttribute("studentTalkList")List<Student> students,
                                RedirectAttributes redirectAttributes) {
        Student student = iStudentService.findById(id);
        students.add(student);
        redirectAttributes.addFlashAttribute("msg","Add talk list successfully(Session)");
        return "redirect:/student/list";
    }

    @GetMapping(value = "/detail/{id}")
//    @ResponseBody thay cho @RestController
    public String getStudentDetail(@PathVariable(name = "id") Integer id, Model model) throws Exception {

        Student student = iStudentService.findById(id);
        if (student == null) {
            throw new RuntimeException();
        }
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
        String[] genders = {"Nam", "Nữ", "Khác"};
        model.addAttribute("genders", genders);
        model.addAttribute("classes", iClassService.findAll());
        model.addAttribute("student", new StudentDTO());
        return "student/create_student";
    }

    @PostMapping(value = "/create")
//    @Valid -> validate toàn bộ thuộc tính của model
//    @Validated -> hỗ trợ validate 1 phần/nhóm của model
    // BindingResult phải luôn luôn đứng ngay sau model cần validate
    public String createStudent(@Valid @ModelAttribute("student") StudentDTO studentDto,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model,
                                HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int cookieCount) {

//       new StudentDTO().validate(studentDto,bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("classes", iClassService.findAll());
            return "student/create_student";
        }
        iStudentService.save(studentDto);
        Cookie cookie = new Cookie("cookieCount", cookieCount + 1 + "");
//Public cookie sang các đường dẫn khác trong application
        cookie.setPath("/");
        cookie.setHttpOnly(false);
        cookie.setMaxAge(24 * 60 * 60); //24h
        response.addCookie(cookie);

        redirectAttributes.addFlashAttribute("msg", "Create student successfully!(cookieCount)");
        return "redirect:http://localhost:8080/student/list";
    }

    //    @GetMapping("search")
//    public String searchStudent(@RequestParam(name = "name")String name, Model model) {
//        List<Student> studentList= iStudentService.findByName(name);
//        model.addAttribute("students", studentList);
//        return "student/list_student";
//    }
    @GetMapping(value = {"/list", ""})
    public ModelAndView listPage(@RequestParam(value = "name", defaultValue = "") String name) {
        return new ModelAndView("student/list_student", "students", iStudentService.findByName(name));
    }

    @GetMapping(value = "list-page")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("name").descending();
        Page<Student> studentPage = iStudentService.findAll(PageRequest.of(page, 5, sort));
        model.addAttribute("studentPage", studentPage);
        return "student/list_page";
    }

//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        System.out.println("Hello1");
//        return "student/test";
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//        public String handleException1() {
//        System.out.println("Hello2");
//        return "student/test";
//    }
}
