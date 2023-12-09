package com.example.mymodel.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mymodel.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
