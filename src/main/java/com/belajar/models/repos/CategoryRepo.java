package com.belajar.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category,Long> {
  
}
