package dw.wholesale_company.controller;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomerAll(){
        return new ResponseEntity<>(customerService.getCustomerAll(), HttpStatus.OK);
    }

    @GetMapping("/customers/AboveAverage")
    public ResponseEntity<List<Customer>> getCustomerAboveAverage(){
        return new ResponseEntity<>(customerService.getCustomerAboveAverage(), HttpStatus.OK);
    }
}
