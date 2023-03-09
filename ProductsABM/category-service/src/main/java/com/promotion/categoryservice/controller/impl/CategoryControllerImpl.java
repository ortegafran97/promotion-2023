package com.promotion.categoryservice.controller.impl;

import com.promotion.categoryservice.controller.CategoryController;
import com.promotion.categoryservice.entity.Category;
import com.promotion.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryControllerImpl implements CategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Override
    public ResponseEntity<Optional<Category>> findById(UUID idCategory) {
        return ResponseEntity.ok(categoryService.findById(idCategory));
    }

    @Override
    public ResponseEntity<Category> saveOne(Category category) {
        return ResponseEntity.ok(categoryService.saveOne(category));
    }
}
