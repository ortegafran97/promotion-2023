package com.promotion.productsservice.FeignClients;

import com.promotion.productsservice.Model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient(name="category-service", path="/category")
public interface CategoryFeignClient {

    @GetMapping
    List<Category> findAll();

    @GetMapping("/{id}")
    Optional<Category> findById(@PathVariable("id") UUID idCategory);

    @PostMapping
    Category saveOne(Category category);

    @PutMapping("/{id}")
    Optional<Category> updateOne(@PathVariable("id") UUID id,@RequestBody Category category);

    @DeleteMapping("/{id}")
    Boolean deleteOne(UUID idCategory);

}
