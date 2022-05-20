package com.customer.restapi.controller;

import com.customer.restapi.model.Customer;
import com.customer.restapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @CrossOrigin
    @GetMapping("/customer")
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    @CrossOrigin
    @PostMapping("/customer")
    public Customer addCustomer(@NonNull @Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return customer;
    }
}
