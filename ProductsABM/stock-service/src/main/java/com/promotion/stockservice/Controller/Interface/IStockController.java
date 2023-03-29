package com.promotion.stockservice.Controller.Interface;

import com.promotion.stockservice.Model.Stock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Api(value = "stock", description = "Operaciones relacionadas con stock")
public interface IStockController {

    @ApiOperation(value = "Obtener el stock de los productos", response = Stock.class, responseContainer = "List")
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
    ResponseEntity<Map<String, String>> findByProductId(@PathVariable("id") UUID idProduct);

    @PostMapping("/product/{id}/decrease")
    ResponseEntity<Map<String, String>> decreaseStock(@PathVariable("id") UUID idProduct, @RequestBody Stock stock);

}
