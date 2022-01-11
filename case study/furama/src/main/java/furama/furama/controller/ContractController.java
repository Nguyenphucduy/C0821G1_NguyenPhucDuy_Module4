package furama.furama.controller;

import furama.furama.dto.contract.ContractDTO;
import furama.furama.dto.customer.CustomerDTO;
import furama.furama.model.contract.AttachService;
import furama.furama.model.contract.Contract;
import furama.furama.model.contract.ContractDetail;
import furama.furama.service.furama.contract.IContractService;
import furama.furama.service.furama.contract.attach_service.IAttachService;
import furama.furama.service.furama.contract.contract_detail.IContractDetailService;
import furama.furama.service.furama.customer.ICustomerService;
import furama.furama.service.furama.employee.IEmployeeService;
import furama.furama.service.furama.service_resort.IServiceResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IServiceResortService iServiceResortService;

    @Autowired
    IAttachService iAttachService;
    @Autowired
    IContractDetailService iContractDetailService;

    @GetMapping("/user/list")
    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("contractCode").descending();
        Page<Contract> contracts = iContractService.findAllPage((PageRequest.of(page, 2, sort)));
        model.addAttribute("contracts", contracts);
        return "/furama/contract/list";
    }

    @GetMapping("/admin/create-page")
    public String createPage(Model model) {
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("customers", iCustomerService.findAll());
        model.addAttribute("serviceResorts", iServiceResortService.findAll());
        model.addAttribute("contract", new Contract());
        return "/furama/contract/create";
    }


    @PostMapping("/admin/create")
    public String createCustomer(@Valid @ModelAttribute("contract") ContractDTO contractDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", iEmployeeService.findAll());
            model.addAttribute("customers", iCustomerService.findAll());
            model.addAttribute("serviceResorts", iServiceResortService.findAll());
            return "furama/contract/create";
        }
        iContractService.saveContractDTO(contractDTO);
//        iContractService.save(contract);

//        ContractDetail contractDetail = new ContractDetail();
//        contractDetail.setContract(contract);
//        // test trước
//        AttachService attachService = null;
//        for (AttachService attachService1 : iAttachService.findAll()){
//            if (attachService1.getAttachServiceId()==1){
//                attachService = attachService1;
//            }
//        }
//        contractDetail.setAttachService(attachService);
//        iContractDetailService.save(contractDetail);


        redirectAttributes.addFlashAttribute("messenger", "create done");
        return "redirect:/contract/user/list";
    }

    @GetMapping("/admin/{id}/update")
    public String updatePage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contract", iContractService.findById(id));
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("customers", iCustomerService.findAll());
        model.addAttribute("serviceResorts", iServiceResortService.findAll());
        return "/furama/contract/update";
    }

    @PostMapping("/admin/update")
    public String updateCustomer(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("messenger", "update done");
        return "redirect:/contract/user/list";
    }


    @GetMapping("/admin/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        iContractService.deleteById(id);

        for (ContractDetail contractDetail : iContractDetailService.findAll()) {
            if (contractDetail.getContract().getContractId().equals(id)) {
                iContractDetailService.delete(contractDetail);
            }
        }
        redirectAttributes.addFlashAttribute("messenger", "delete done");
        return "redirect:/contract/user/list";
    }

    @GetMapping("user/{id}/view")
    public String view(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contract", iContractService.findById(id));
        return "furama/contract/view";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/furama/error";
    }
}
