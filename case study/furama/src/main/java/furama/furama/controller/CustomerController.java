package furama.furama.controller;

import furama.furama.dto.customer.CustomerDTO;
import furama.furama.model.customer.Customer;
import furama.furama.service.furama.contract.attach_service.IAttachService;
import furama.furama.service.furama.customer.ICustomerService;
import furama.furama.service.furama.customer.customer_type.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @Autowired
    IAttachService iAttachService;


    @GetMapping("/user/list")
    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Sort sort = Sort.by("name").descending();
        Page<Customer> customers = iCustomerService.findAll((PageRequest.of(page, 2, sort)));
        model.addAttribute("customers",customers);
        return "/furama/customer/list";
    }
// Request 2 Câu 8
    @GetMapping("/user/customer-using-service")
    public String getCustomerUsingService(Model model){
        model.addAttribute("customers",iCustomerService.findCustomerUsingService());
        return "/furama/customer/list-search";
    }

    @GetMapping("/user/attach-service")
    public String getAttachService(Model model){
        model.addAttribute("attachServices",iAttachService.findAttachService());
        return "/furama/customer/list-attach-service";
    }
// ----------------------------
    @GetMapping("/admin/create-page")
    public String createPage(Model model){
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        model.addAttribute("customer",new Customer());
        return "/furama/customer/create";
    }

    @PostMapping("/admin/create")
    public String createCustomer(@Valid @ModelAttribute("customer") CustomerDTO customerDTO,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){

        new CustomerDTO().validate(customerDTO,bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes",iCustomerTypeService.findAll());
            return "furama/customer/create";
        }

        iCustomerService.saveCustomerDTO(customerDTO);
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
    public String updateCustomer(@Valid @ModelAttribute("customer") CustomerDTO customerDTO,BindingResult bindingResult,Model model,  RedirectAttributes redirectAttributes){
        new CustomerDTO().validate(customerDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes",iCustomerTypeService.findAll());
            return "furama/customer/update";
        }
        iCustomerService.updateCustomer(customerDTO);
        redirectAttributes.addFlashAttribute("messenger","update done");
        return "redirect:/customer/user/list";
    }


    @GetMapping("/admin/{id}/delete")
    public String delete(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes) throws Exception {
        iCustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("messenger","delete done");
        return "redirect:/customer/user/list";
    }

    @GetMapping("user/{id}/view")
    public String view(@PathVariable("id") Integer id,Model model) throws Exception {
        if (id==1){
            throw new Exception();
        }
        model.addAttribute("customer",iCustomerService.findById(id));
        return "furama/customer/view";
    }
    @PostMapping("/user/search")
    public String search(@RequestParam(name = "name")String name, Model model, Pageable pageable){
        String nameNew = "%"+name+"%";

        Page<Customer> customers = iCustomerService.findByNamePage(nameNew,pageable);
        model.addAttribute("customers",customers);
        return "/furama/customer/list";

    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/furama/error";
    }
}
