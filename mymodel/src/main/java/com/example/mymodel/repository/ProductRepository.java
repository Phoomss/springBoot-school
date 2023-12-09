package com.example.mymodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mymodel.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
