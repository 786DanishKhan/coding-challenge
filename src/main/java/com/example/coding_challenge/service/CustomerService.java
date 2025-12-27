package com.example.coding_challenge.service;

import com.example.coding_challenge.dto.CustomerDto;
import com.example.coding_challenge.entity.Customer;
import com.example.coding_challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public void addCustomer(List<CustomerDto> customerDtos) {
        for (CustomerDto c : customerDtos) {
            Customer obj = new Customer(c.getName(), c.getEmail());
            customerRepository.save(obj);

        }
    }

    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer c : customers) {
            CustomerDto obj = new CustomerDto(c.getId(), c.getName(), c.getEmail());
            customerDtos.add(obj);
        }
        return customerDtos;

    }

}
