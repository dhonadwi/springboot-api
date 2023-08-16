package com.belajar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.helpers.ResponseData;
import com.belajar.models.entities.Product;
import com.belajar.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors) {
    List<String> message = new ArrayList<>();
    ResponseData<Product> responseData = new ResponseData<>();
    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
    message.add("Data has been submitted");
    responseData.setMessages(message);
    responseData.setStatus(true);
    responseData.setPayload(productService.save(product));
    return ResponseEntity.ok(responseData);
  }

  @GetMapping
  public ResponseEntity<Object> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public  ResponseEntity<Object> findOne(@PathVariable("id") Long id) {
    return productService.findOne(id);
  }

   @PutMapping
   public Product update(@RequestBody Product product) {
     return productService.save(product);
   }
  
   @DeleteMapping("/{id}")
  public void removeOne(@PathVariable("id") Long id) {
    productService.removeOne(id);
  }
}
