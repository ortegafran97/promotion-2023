package com.promotion.stockservice.Repository;

import com.promotion.stockservice.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {
    List<Stock> findByIdProduct(UUID idProduct);
}
