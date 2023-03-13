package com.promotion.categoryservice.service.impl;

import com.promotion.categoryservice.entity.Category;
import com.promotion.categoryservice.repository.CategoryRepository;
import com.promotion.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
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

    @Override
    public Optional<Category> updateOne(Category category) {
        Optional<Category> updatedCategory = findById(category.getId());
        if (updatedCategory.isEmpty())
            return Optional.empty();
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Boolean deleteOne(UUID idCategory) {
        categoryRepository.deleteById(idCategory);
        return findById(idCategory).isEmpty();
    }
}

