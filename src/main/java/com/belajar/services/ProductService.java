package com.belajar.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.models.entities.Product;
import com.belajar.models.repos.ProductRepo;

@Service
@Transactional
public class ProductService {
  
  @Autowired
  private ProductRepo productRepo;

  public Product save(Product product) {
    return productRepo.save(product);
  }

  public Product findOne(Long id) {
    return productRepo.findById(id).get();
  }

  public Iterable<Product> findAll() {
    return productRepo.findAll();
  }

  public void removeOne(Long id) {
    productRepo.deleteById(id);
  }

  public List<Product> findByNameContains(String name) {
    return productRepo.findByNameContains(name);
  }
}
