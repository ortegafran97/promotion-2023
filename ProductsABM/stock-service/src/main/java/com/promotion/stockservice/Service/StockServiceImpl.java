package com.promotion.stockservice.Service;

import com.promotion.stockservice.Model.Stock;
import com.promotion.stockservice.Repository.StockRepository;
import com.promotion.stockservice.Service.Interface.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> findById(UUID idStock) {
        return stockRepository.findById(idStock);
    }

    @Override
    public List<Stock> findByProductId(UUID idProduct) {
        return stockRepository.findByIdProduct(idProduct);
    }

    @Override
    public Boolean deleteById(UUID idStock) {
        stockRepository.deleteById(idStock);
        return stockRepository.findById(idStock).isEmpty();
    }

    @Override
    public Optional<Stock> updateOne(Stock stock) {
        if(stock.getId()==null || stockRepository.findById(stock.getId()).isEmpty())
            return Optional.empty();

        return Optional.of(stockRepository.save(stock));
    }

    @Override
    public Optional<Stock> saveOne(Stock stock) {
        if(stock.getId() != null && stockRepository.findById(stock.getId()).isPresent())
            return null;

        return Optional.of(stockRepository.save(stock));
    }
}
