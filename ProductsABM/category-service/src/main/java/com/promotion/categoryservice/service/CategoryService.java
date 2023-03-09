package com.promotion.categoryservice.service;

import com.promotion.categoryservice.entity.Category;


import java.util.List;
import java.util.UUID;

public interface CategoryService {

List<Category> findAll();
Category findById(UUID idCategory);
Category saveOne(Category category);



}
