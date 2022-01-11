package furama.furama.utils.validate;

import furama.furama.model.contract.Contract;
import furama.furama.model.customer.Customer;
import furama.furama.model.employee.Employee;
import furama.furama.model.serviceResort.ServiceResort;
import furama.furama.service.furama.contract.IContractService;
import furama.furama.service.furama.customer.ICustomerService;
import furama.furama.service.furama.employee.IEmployeeService;
import furama.furama.service.furama.service_resort.IServiceResortService;
import furama.furama.utils.CodeConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodeValidate implements ConstraintValidator<CodeConstraint,String> {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IContractService iContractService;
    @Autowired
    IServiceResortService iServiceResortService;

    @Override
    public void initialize(CodeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        for (Customer customer : iCustomerService.findAll()){
            if (customer.getCustomerCode().equals(code)){
                return false;
            }
        }
        for (Contract contract : iContractService.findAll()){
            if (contract.getContractCode().equals(code)){
                return false;
            }
        }
        for (Employee employee : iEmployeeService.findAll()){
            if (employee.getEmployeeCode().equals(code)){
                return false;
            }
        }
        for (ServiceResort serviceResort: iServiceResortService.findAll()){
            if (serviceResort.getCodeServiceResort().equals(code)){
                return false;
            }
        }
        return true;
    }
}
