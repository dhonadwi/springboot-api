package com.belajar.services;

import java.util.Optional;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.models.entities.Supplier;
import com.belajar.models.repos.SupplierRepo;

@Service
@TransactionScoped
public class SupplierService {
  
  @Autowired
  private SupplierRepo supplierRepo;

  public Supplier save(Supplier supplier) {
    return supplierRepo.save(supplier);
  }

  public Supplier findOne(Long id) {
    Optional<Supplier> supplier = supplierRepo.findById(id);
    if (!supplier.isPresent()) {
      return null;
    }
    return supplier.get();
  }

  public Iterable<Supplier> findAll() {
    return supplierRepo.findAll();
  }

  public void removeOne(Long id) {
    supplierRepo.deleteById(id);
  }
}
