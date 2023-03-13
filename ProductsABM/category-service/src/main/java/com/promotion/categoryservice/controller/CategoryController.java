package com.promotion.categoryservice.controller;

import com.promotion.categoryservice.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CategoryController {

    @GetMapping()
    ResponseEntity<List<Category>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Optional<Category>> findById(@PathVariable("id") UUID idCategory);

    @PostMapping()
    ResponseEntity<Category> saveOne(@RequestBody Category category);

    @PutMapping("/{id}")
    ResponseEntity<Optional<Category>> updateOne(@PathVariable("id") UUID id, @RequestBody Category category);

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteOne(@PathVariable("id") UUID idCategory);


}
