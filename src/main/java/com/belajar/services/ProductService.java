package com.belajar.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  public ResponseEntity<Object> findOne(Long id) {
    Optional<Product> product = productRepo.findById(id);
    if (!product.isPresent()) {
      ResponseMessage errorMessage = new ResponseMessage("data not found", false, product);
      return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    ResponseMessage resMessage = new ResponseMessage("data found", true, product.get());
    return new ResponseEntity<>(resMessage, HttpStatus.OK);
  }

  public ResponseEntity<Object> findAll() {
    ResponseMessage responseMessage = new ResponseMessage("data found", true, productRepo.findAll());
    return new ResponseEntity<>(responseMessage, HttpStatus.OK);
  }

  public void removeOne(Long id) {
    productRepo.deleteById(id);
  }

  public List<Product> findByNameContains(String name) {
    return productRepo.findByNameContains(name);
  }

  public class ResponseMessage {
    private String message;
    private boolean status;
    private Object product;

    public ResponseMessage(String message, boolean status, Object product) {
      this.message = message;
      this.status = status;
      this.product = product;
    }

    public Object getProduct() {
      return product;
    }

    public void setProduct(Object product) {
      this.product = product;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public boolean isStatus() {
      return status;
    }

    public void setStatus(boolean status) {
      this.status = status;
    }
  }

}
