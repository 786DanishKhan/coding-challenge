package com.example.coding_challenge.controller;

import com.example.coding_challenge.dto.CustomerDto;
import com.example.coding_challenge.entity.Customer;
import com.example.coding_challenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDto> getCustomer() {
        return customerService.getCustomers();
    }

    /*@PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }*/
    @PostMapping("/customers")
    public void addCustomer(@RequestBody List<CustomerDto> customerDtos) {
        customerService.addCustomer(customerDtos);

    }

    @GetMapping("/customer/{id}/orders")
    public void getOrdersByCustomer() {

    }

    @PostMapping("/customers/{id}/orders")
    public void addOrdersByCustomer() {


    }
}
