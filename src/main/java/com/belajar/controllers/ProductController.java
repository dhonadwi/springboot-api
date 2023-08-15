package com.belajar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.models.entities.Product;
import com.belajar.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @PostMapping
  public Product create(@RequestBody Product product) {
    return productService.save(product);
  }

  @GetMapping
  public Iterable<Product> findAll() {
    return productService.findAll();
  }
}
