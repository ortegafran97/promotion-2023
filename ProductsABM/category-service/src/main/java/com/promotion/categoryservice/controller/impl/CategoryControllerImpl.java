package com.promotion.categoryservice.controller.impl;

import com.promotion.categoryservice.controller.CategoryController;
import com.promotion.categoryservice.entity.Category;
import com.promotion.categoryservice.exceptions.clases.AlreadyExistsException;
import com.promotion.categoryservice.exceptions.clases.NotFoundException;
import com.promotion.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/category")
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Override
    public ResponseEntity<Optional<Category>> findById(UUID idCategory) {
        Optional<Category> category = categoryService.findById(idCategory);
        if(category.isEmpty())
            throw new NotFoundException("La categoria no se encontro");
        return ResponseEntity.ok(category);
    }

    @Override
    public ResponseEntity<Category> saveOne(Category category) {
        if(category.getId() != null && categoryService.findById(category.getId()).isPresent())
            throw new AlreadyExistsException("La categoría ya fue creada anteriormente");
        return ResponseEntity.ok(categoryService.saveOne(category));
    }

    @Override
    public ResponseEntity<Optional<Category>> updateOne(UUID id, Category category) {
        category.setId(id);
        Optional<Category> updatedCategory = categoryService.updateOne(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @Override
    public ResponseEntity<Boolean> deleteOne(UUID idCategory) {
       categoryService.deleteOne(idCategory);
       return ResponseEntity.ok(true);
    }
}
