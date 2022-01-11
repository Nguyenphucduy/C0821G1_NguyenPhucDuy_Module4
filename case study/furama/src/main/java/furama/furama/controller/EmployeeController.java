package furama.furama.controller;

import furama.furama.dto.employee.EmployeeDTO;
import furama.furama.model.customer.Customer;
import furama.furama.model.employee.AppRole;
import furama.furama.model.employee.AppUser;
import furama.furama.model.employee.Employee;
import furama.furama.model.employee.UserRole;
import furama.furama.service.furama.employee.IEmployeeService;
import furama.furama.service.furama.employee.division.IDivisionService;
import furama.furama.service.furama.employee.education_degree.IEducationDegreeService;
import furama.furama.service.furama.employee.position.IPositionService;
import furama.furama.service.furama.employee.role.IRoleService;
import furama.furama.service.furama.employee.user.IAppUserService;
import furama.furama.service.furama.employee.user_role.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IDivisionService iDivisionService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IEducationDegreeService iEducationDegreeService;
    @Autowired
    IAppUserService iAppUserService;

    @Autowired
    IUserRoleService iUserRoleService;

    @Autowired
    IRoleService iRoleService;

    @GetMapping("/user/list")
    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        // colum trong DB
        Sort sort = Sort.by("name").descending();
        Page<Employee> employees = iEmployeeService.findAllPage((PageRequest.of(page, 2, sort)));
        model.addAttribute("employees",employees);
        return "/furama/employee/list";
    }


    @GetMapping("/admin/create-page")
    public String createPage(Model model){
        model.addAttribute("divisions",iDivisionService.findAll());
        model.addAttribute("positions",iPositionService.findAll());
        model.addAttribute("educationDegrees",iEducationDegreeService.findAll());
        model.addAttribute("employee",new Employee());
        return "/furama/employee/create";
    }
    @PostMapping("/admin/create")
    public String createEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            model.addAttribute("divisions",iDivisionService.findAll());
            model.addAttribute("positions",iPositionService.findAll());
            model.addAttribute("educationDegrees",iEducationDegreeService.findAll());
            return "furama/employee/create";
        }

//        AppUser appUser = new AppUser();
//        appUser.setUserName(employee.getAppUser().getUserName());
//        appUser.setEnabled("0");
//        appUser.setEncrytedPassword("$2a$12$X2xz.FXnKzN3jw0n0xQuhuckm3hlW8jLImiOqVPOVWmtTTQSZhH3q");
//        iAppUserService.save(appUser);
//
//        // phân quyền
//
//        UserRole userRole = new UserRole();
//
//
//        AppRole appRole1 = null;
//        for (AppRole appRole :iRoleService.findAll()){
//            if (appRole.getRoleId()==2){// Role_User
//                appRole1 = appRole;
//            }
//        }
//
//        userRole.setAppRole(appRole1);
//        userRole.setAppUser(appUser);
//        iUserRoleService.save(userRole);
//
//        employee.setAppUser(appUser);

        iEmployeeService.saveEmployeeDTO(employeeDTO);
        redirectAttributes.addFlashAttribute("messenger","create done");
        return "redirect:/employee/user/list";
    }

    @GetMapping("/admin/{id}/update")
    public String updatePage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("employee",iEmployeeService.findById(id));
        model.addAttribute("divisions",iDivisionService.findAll());
        model.addAttribute("positions",iPositionService.findAll());
        model.addAttribute("educationDegrees",iEducationDegreeService.findAll());
        return "/furama/employee/update";
    }
    @PostMapping("/admin/update")
    public String updateCustomer(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisions",iDivisionService.findAll());
            model.addAttribute("positions",iPositionService.findAll());
            model.addAttribute("educationDegrees",iEducationDegreeService.findAll());
            return "furama/employee/update";
        }
        iEmployeeService.updateEmployeeDTO(employeeDTO);
        redirectAttributes.addFlashAttribute("messenger","update done");
        return "redirect:/employee/user/list";
    }


    @GetMapping("/admin/{id}/delete")
//    @ResponseBody
    public String delete(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        iEmployeeService.deleteById(id);
        redirectAttributes.addFlashAttribute("messenger","delete done");
        return "redirect:/employee/user/list";
    }

    @GetMapping("user/{id}/view")
    public String view(@PathVariable("id") Integer id,Model model){
        model.addAttribute("employee",iEmployeeService.findById(id));
        return "furama/employee/view";
    }
    @PostMapping("/user/search")
    public String search(@RequestParam(name = "name")String name, Model model, Pageable pageable){
        String nameNew = "%"+name+"%";
        Page<Employee> employees = iEmployeeService.findByNamePage(nameNew,pageable);
        model.addAttribute("employees",employees);
        return "/furama/employee/list";
//        model.addAttribute("employees", iEmployeeService.findByName(nameNew));
//        return "/furama/employee/list-search";
    }
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/furama/error";
    }
}
