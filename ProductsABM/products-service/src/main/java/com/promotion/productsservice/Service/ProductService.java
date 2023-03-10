package com.promotion.productsservice.Service;

import com.promotion.productsservice.Model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(UUID idProduct);
    Product saveOne(Product product);
    Optional<Product> updateOne(Product product);
    Boolean deleteOne(UUID idProduct);
}
