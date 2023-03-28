package com.promotion.categoryservice.controller;

import com.promotion.categoryservice.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Api(value = "categorias", description = "Operaciones relacionadas con categorias")
public interface CategoryController {

    @ApiOperation(value = "Obtener todas las categorias", response = Category.class, responseContainer = "List")
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
