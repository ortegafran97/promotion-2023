package com.promotion.productsservice.Service;

import com.promotion.productsservice.Model.Category;
import com.promotion.productsservice.Model.Product;
import com.promotion.productsservice.Model.Stock;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(UUID idProduct);
    Product saveOne(Product product);
    Optional<Product> updateOne(Product product);
    Boolean deleteOne(UUID idProduct);


    /* Products */
    List<Category> findAllCategories();
    Optional<Category> findCategoryById(UUID idCategory);
    Optional<Category> findProductCategory(UUID idProduct);


    /* Stock */
    Optional<Stock> findProductStock(UUID idProduct);
    Optional<Stock> decreaseStock(UUID idProduct, Integer quantity);
    Optional<Stock> saveStock(Stock stock);

}
