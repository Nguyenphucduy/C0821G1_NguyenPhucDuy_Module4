package furama.furama.controller;

import furama.furama.model.customer.Customer;
import furama.furama.service.furama.customer.ICustomerService;
import furama.furama.service.furama.customer_type.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;


    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("customers",iCustomerService.findAll());
        return "/furama/customer/list";
    }
    @GetMapping("/create-page")
    public String createPage(Model model){
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        model.addAttribute("customer",new Customer());
        return "/furama/customer/create";
    }
    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
//        if (customer==null){
//            redirectAttributes.addFlashAttribute("messenger","error");
//            return "redirect:/customer/create-page";
//        }
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messenger","create done");
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/update")
    public String updatePage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        return "/furama/customer/update";
    }
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer,  RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messenger","update done");
        return "redirect:/customer/list";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        iCustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("messenger","delete done");
        return "redirect:/customer/list";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        return "furama/customer/view";
    }

}
