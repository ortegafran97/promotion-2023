package com.promotion.stockservice.Controller;


import com.promotion.stockservice.Controller.Interface.IStockController;
import com.promotion.stockservice.Exceptions.Classes.CouldntCompleteException;
import com.promotion.stockservice.Exceptions.Classes.NotFoundException;
import com.promotion.stockservice.Model.Stock;
import com.promotion.stockservice.Service.Interface.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/stock")
public class StockControllerImpl implements IStockController {

    @Autowired
    StockService stockService;

    @Override
    public ResponseEntity<List<Stock>> findAll() {
        return ResponseEntity.ok(stockService.findAll());
    }

    @Override
    public ResponseEntity<Optional<Stock>> findById(UUID idStock) {
        Optional<Stock> stock = stockService.findById(idStock);

        if(stock.isEmpty())
            throw new NotFoundException("El stock con registro "+idStock+" no existe.");


        return ResponseEntity.ok(stock);
    }

    @Override
    public ResponseEntity<Optional<Stock>> saveOne(Stock stock) {
        Optional<Stock> newStock = stockService.saveOne(stock);

        if(newStock.isEmpty())
            throw new CouldntCompleteException("Error al guardar stock nuevo.");

        return ResponseEntity.ok(newStock);
    }

    @Override
    public ResponseEntity<Optional<Stock>> updateOne(UUID idStock, Stock stock) {
        stock.setId(idStock);
        Optional<Stock> updated = stockService.updateOne(stock);

        if(updated.isEmpty())
            throw new CouldntCompleteException("Error al actualizar el stock.");

        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Boolean> deleteOne(UUID idStock) {
        Optional<Stock> exists = stockService.findById(idStock);

        if(exists.isEmpty())
            throw new NotFoundException("No existe el registro de stock con id " + idStock);

        return ResponseEntity.ok(stockService.deleteById(idStock));
    }

    @Override
    public ResponseEntity<List<Stock>> findByProductId(UUID idProduct) {
        List<Stock> stocks = stockService.findByProductId(idProduct);

        if(stocks.isEmpty())
            throw new NotFoundException("No existen stocks para el productos indicado");

        return ResponseEntity.ok(stocks);
    }
}
