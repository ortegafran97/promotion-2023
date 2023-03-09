package com.promotion.productsservice.Controller;

import com.promotion.productsservice.Model.Product;
import com.promotion.productsservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> saveOne(@RequestBody Product product){
        return ResponseEntity.ok(productService.saveOne(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable("id")UUID idProduct){
        return ResponseEntity.ok(productService.deleteOne(idProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Product>> updateOne(@PathVariable("id") UUID id, @RequestBody Product product){
        product.setId(id);

        return ResponseEntity.ok(productService.updateOne(product));
    }
}
