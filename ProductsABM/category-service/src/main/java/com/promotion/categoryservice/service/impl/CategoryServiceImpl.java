package com.promotion.categoryservice.service.impl;

import com.promotion.categoryservice.entity.Category;
import com.promotion.categoryservice.repository.CategoryRepository;
import com.promotion.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(UUID idCategory) {
        return categoryRepository.findById(idCategory);
    }

    @Override
    public Category saveOne(Category category) {
        return categoryRepository.save(category);
    }
}

