package com.promotion.stockservice.Controller.Interface;

import com.promotion.stockservice.Model.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IStockController {
    @GetMapping
    ResponseEntity<List<Stock>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Optional<Stock>> findById(@PathVariable("id")UUID idStock);

    @PostMapping
    ResponseEntity<Optional<Stock>> saveOne(@RequestBody Stock stock);

    @PutMapping("/{id}")
    ResponseEntity<Optional<Stock>> updateOne(@PathVariable("id") UUID idStock, @RequestBody Stock stock);

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteOne(@PathVariable("id")UUID idStock);


    /* Products methods*/
    @GetMapping("/product/{id}")
    ResponseEntity<List<Stock>> findByProductId(@PathVariable("id") UUID idProduct);

}
