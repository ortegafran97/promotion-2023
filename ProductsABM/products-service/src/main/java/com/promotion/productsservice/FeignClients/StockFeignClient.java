package com.promotion.productsservice.FeignClients;

import com.promotion.productsservice.Model.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@FeignClient(name="stock-service", path="/stock")
public interface StockFeignClient {

    @GetMapping
    List<Stock> findALl();

    @GetMapping("/{idStock}")
    Optional<Stock> findById(@PathVariable("idStock") UUID idStock);

    @PostMapping
    Optional<Stock> saveOne(@RequestBody Stock stock);

    @PutMapping("/{id}")
    Optional<Stock> updateOne(@PathVariable("id") UUID idStock, @RequestBody Stock stock);

    @DeleteMapping("/{id}")
    Boolean deleteOne(@PathVariable("id") UUID idStock);

    @GetMapping("/product/{idProduct}")
    List<Stock> findStockByProductId(@PathVariable("idProduct") UUID idProduct);
}
