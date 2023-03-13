package com.promotion.categoryservice.service;

import com.promotion.categoryservice.entity.Category;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    List<Category> findAll();

    Optional findById(UUID idCategory);

    Category saveOne(Category category);

    Optional<Category> updateOne(Category category);

    Boolean deleteOne(UUID idCategory);


}
