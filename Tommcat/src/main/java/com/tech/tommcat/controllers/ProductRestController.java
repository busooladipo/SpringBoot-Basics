package com.tech.tommcat.controllers;

import com.tech.tommcat.Repos.ProductRepo;
import com.tech.tommcat.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepo productRepo;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") int id){
        return productRepo.findById(id).get();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable("id") int id){
        productRepo.deleteById(id);
    }
}
