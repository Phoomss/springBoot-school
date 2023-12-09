package com.example.mymodel.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mymodel.model.Customer;
import com.example.mymodel.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all-customer")
    public ResponseEntity<Object> getAllCustomer() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Customer All", customerService);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/create-customer")
    @ResponseBody
    public String index() {
        Customer c = new Customer();
        c.setName("Jam");
        c.setAddress("Bang Len");
        c.setTel("0888888888");

        Customer customerResult = customerService.save(c);
        System.out.println(customerResult.getName());
        return customerResult.getName();
    }

}
