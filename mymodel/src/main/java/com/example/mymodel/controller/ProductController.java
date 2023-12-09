package com.example.mymodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mymodel.model.Product;
import com.example.mymodel.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        Product p = new Product();
        p.setName("Printter");
        p.setPrice(1000);
        p.setStock(70);

        Product productResult = productService.save(p);
        System.out.println(productResult.getId());
        System.out.println(productResult.getName());
        System.out.println(productResult.getPrice());
        System.out.println(productResult.getStock());
        return "New Product";
    }

}
