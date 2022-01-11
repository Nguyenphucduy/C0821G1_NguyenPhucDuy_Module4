package furama.furama.controller;

import furama.furama.dto.service_resort.ServiceResortDTO;
import furama.furama.model.serviceResort.ServiceResort;
import furama.furama.service.furama.service_resort.IServiceResortService;
import furama.furama.service.furama.service_resort.rent_type.IRentTypeService;
import furama.furama.service.furama.service_resort.service_type.IServiceTypeService;
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
@RequestMapping("/service-resort")
public class ServiceResortController {
    @Autowired
    IServiceResortService iServiceResortService;
    @Autowired
    IRentTypeService iRentTypeService;
    @Autowired
    IServiceTypeService iServiceTypeService;

        @GetMapping("/user/list")
    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        // property of @Entity
        Sort sort = Sort.by("codeServiceResort").descending();
        Page<ServiceResort> serviceResorts = iServiceResortService.findAllPage((PageRequest.of(page, 2,sort)));
        model.addAttribute("serviceResorts",serviceResorts);
        return "/furama/service-resort/list";
    }


    @GetMapping("/admin/create-page")
    public String createPage(Model model) {
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("serviceTypes", iServiceTypeService.findAll());
        model.addAttribute("serviceResort", new ServiceResort());
        return "/furama/service-resort/create";
    }

    @PostMapping("/admin/create")
    public String createCustomer(@Valid @ModelAttribute("serviceResort") ServiceResortDTO serviceResortDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("rentTypes", iRentTypeService.findAll());
            model.addAttribute("serviceTypes", iServiceTypeService.findAll());
            return "furama/service-resort/create";
        }

        iServiceResortService.saveServiceResortDTO(serviceResortDTO);
        redirectAttributes.addFlashAttribute("messenger", "create done");
        return "redirect:/service-resort/user/list";
    }

    @GetMapping("/admin/{id}/update")
    public String updatePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("serviceTypes", iServiceTypeService.findAll());
        model.addAttribute("serviceResort", iServiceResortService.findById(id));
        return "/furama/service-resort/update";
    }

    @PostMapping("/admin/update")
    public String updateCustomer(@ModelAttribute("serviceResort") ServiceResort serviceResort, RedirectAttributes redirectAttributes) {
        iServiceResortService.save(serviceResort);
        redirectAttributes.addFlashAttribute("messenger", "update done");
        return "redirect:/service-resort/user/list";
    }


    @GetMapping("/admin/{id}/delete")
//    @ResponseBody
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        iServiceResortService.deleteById(id);
        redirectAttributes.addFlashAttribute("messenger", "delete done");
        return "redirect:/service-resort/user/list";
    }

    @GetMapping("user/{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("serviceResort", iServiceResortService.findById(id));
        return "furama/service-resort/view";
    }
    @PostMapping("/user/search")
    public String search(@RequestParam(name = "name")String name, Model model, Pageable pageable){
        String nameNew = "%"+name+"%";

        model.addAttribute("serviceResorts", iServiceResortService.findByNamePage(nameNew,pageable));
        return "/furama/service-resort/list";
    }
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/furama/error";
    }
}
