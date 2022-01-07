package furama.furama.controller;

import furama.furama.model.customer.Customer;
import furama.furama.service.furama.customer.ICustomerService;
import furama.furama.service.furama.customer_type.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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


    @GetMapping("/user/list")
    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        // colum trong DB
        Sort sort = Sort.by("name").descending();
        Page<Customer> customers = iCustomerService.findAll((PageRequest.of(page, 2, sort)));
        model.addAttribute("customers",customers);
        return "/furama/customer/list";
    }
    @GetMapping("/admin/create-page")
    public String createPage(Model model){
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        model.addAttribute("customer",new Customer());
        return "/furama/customer/create";
    }
    @PostMapping("/admin/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
//        if (customer==null){
//            redirectAttributes.addFlashAttribute("messenger","error");
//            return "redirect:/customer/create-page";
//        }
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messenger","create done");
        return "redirect:/customer/user/list";
    }

    @GetMapping("/admin/{id}/update")
    public String updatePage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        return "/furama/customer/update";
    }
    @PostMapping("/admin/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer,  RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messenger","update done");
        return "redirect:/customer/user/list";
    }


    @GetMapping("/admin/{id}/delete")
//    @ResponseBody
    public String delete(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        iCustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("messenger","delete done");
        return "redirect:/customer/user/list";
    }

    @GetMapping("user/{id}/view")
    public String view(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        return "furama/customer/view";
    }
    @PostMapping("/user/search")
    public String search(@RequestParam(name = "name")String name,Model model,@RequestParam(value = "page", defaultValue = "0") int page){
        String nameNew = "%"+name+"%";

//        Page<Customer> customers = iCustomerService.findByNamePage(nameNew,(PageRequest.of(page, 2)));
//        model.addAttribute("customers",customers);
//        return "/furama/customer/list";

        model.addAttribute("customers", iCustomerService.findByName(nameNew));
        return "/furama/customer/list-search";
    }
}
