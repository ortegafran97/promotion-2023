package com.promotion.stockservice.Service.Interface;

import com.promotion.stockservice.Model.Stock;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockService {
    List<Stock> findAll();
    Optional<Stock> findById(UUID idStock);
    Stock findByProductId(UUID idProduct);
    Boolean deleteById(UUID idStock);
    Optional<Stock> updateOne(Stock stock);
    Optional<Stock> saveOne(Stock stock);
}
