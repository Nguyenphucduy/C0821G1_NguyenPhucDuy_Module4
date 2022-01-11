package furama.furama.dto.contract;

import furama.furama.model.customer.Customer;
import furama.furama.model.employee.Employee;
import furama.furama.model.serviceResort.ServiceResort;
import furama.furama.utils.CodeConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


public class ContractDTO {
    private Integer contractId;
//    @CodeConstraint()
    @Pattern(regexp = "^HD\\d{4}$", message = "mã hợp đồng HD  và  phải có 4 số")
    @NotBlank(message = "mã hợp đồng không được để trống (NotBlank)")
    private String contractCode;


    @NotBlank(message = "mã hợp đồng không được để trống (NotBlank)")
    private String contractStartDate;


    @NotBlank(message = "mã hợp đồng không được để trống (NotBlank)")
    private String contractEndDate;


//    @NotBlank(message = "mã hợp đồng không được để trống (NotBlank)")
    @Positive(message = "contractDeposit phải lớn hơn 0")
    private Double contractDeposit;

    @Positive(message = "contractTotalMoney phải lớn hơn 0")
    private Double contractTotalMoney;

    private Employee employee;
    private Customer customer;
    private ServiceResort serviceResort;

    public ContractDTO() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceResort getServiceResort() {
        return serviceResort;
    }

    public void setServiceResort(ServiceResort serviceResort) {
        this.serviceResort = serviceResort;
    }
}
