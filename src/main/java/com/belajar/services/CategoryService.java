package com.belajar.services;

import java.util.Optional;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.models.entities.Category;
import com.belajar.models.repos.CategoryRepo;

@Service
@TransactionScoped
public class CategoryService {
  
  @Autowired
  private CategoryRepo categoryRepo;

  public Category save(Category category) {
    return categoryRepo.save(category);
  }

  public Category findOne(Long id) {
    Optional<Category> category = categoryRepo.findById(id);
    if (!category.isPresent()) {
      return null;
    }
    return category.get();
  }

  public Iterable<Category> findAll() {
    return categoryRepo.findAll();
  }

  public void removeOne(Long id) {
    categoryRepo.deleteById(id);
  }
}
