package com.promotion.categoryservice.controller;

import com.promotion.categoryservice.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public interface CategoryController {

    @GetMapping()
    ResponseEntity<List<Category>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Category> findById(@PathVariable("id") UUID idCategory);

    @PostMapping()
    ResponseEntity<Category> saveOne(@RequestBody Category category);



}
