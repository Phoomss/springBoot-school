package com.example.mymodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mymodel.model.Customer;
import com.example.mymodel.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
    public Iterable<Customer> getAll(){
        return customerRepository.findAll();
    }
}
