package furama.furama.controller;

import furama.furama.model.customer.Customer;
import furama.furama.service.furama.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    @Autowired
    ICustomerService iCustomerService;
    @DeleteMapping("/admin/{id}/delete")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
        Customer customer = iCustomerService.findById(id);
        iCustomerService.deleteById(id);
        return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);
    }
}
