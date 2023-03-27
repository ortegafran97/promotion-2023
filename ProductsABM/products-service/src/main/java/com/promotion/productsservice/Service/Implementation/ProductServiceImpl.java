package com.promotion.productsservice.Service.Implementation;

import com.promotion.productsservice.Exceptions.Classes.NotFoundException;
import com.promotion.productsservice.FeignClients.CategoryFeignClient;
import com.promotion.productsservice.FeignClients.StockFeignClient;
import com.promotion.productsservice.Model.Category;
import com.promotion.productsservice.Model.Product;
import com.promotion.productsservice.Model.Stock;
import com.promotion.productsservice.Repository.ProductRepository;
import com.promotion.productsservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryFeignClient categoryFeignClient;

    @Autowired
    StockFeignClient stockFeignClient;

    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(UUID idProduct){
        return productRepository.findById(idProduct);
    }

    @Override
    public Product saveOne(Product product){
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> updateOne(Product product){
        Optional<Product> updatable  = findById(product.getId());

        if(updatable.isEmpty())
            return Optional.empty();

        return Optional.of(productRepository.save(product));
    }

    @Override
    public Boolean deleteOne(UUID idProduct){
        productRepository.deleteById(idProduct);
        return findById(idProduct).isEmpty();
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = categoryFeignClient.findAll();
        return categories;
    }

    @Override
    public Optional<Category> findCategoryById(UUID idCategory) {
        Optional<Category> category = categoryFeignClient.findById(idCategory);
        return category;
    }

    @Override
    public Optional<Category> findProductCategory(UUID idProduct){
        Optional<Product> product = productRepository.findById(idProduct);

        if(product.isEmpty())
            return Optional.empty();

        Optional<Category> category  = findCategoryById(product.get().getCategory_id());

        return category;
    }

    @Override
    public Optional<Stock> findProductStock(UUID idProduct) {
        Optional<Stock> stock = stockFeignClient.findStockByProductId(idProduct);

        if(stock.isEmpty())
            throw new NotFoundException("No hay stock del producto.");

        return stock;
    }

    @Override
    public Optional<Stock> saveStock(Stock stock) {
        Optional<Stock> newStock = stockFeignClient.saveOne(stock);
        return newStock;
    }

    @Override
    public Optional<Stock> decreaseStock(UUID idProduct, Integer quantity) {
        Stock decreaser = new Stock();
        decreaser.setQuantity(quantity);
        decreaser.setId(idProduct);

        return stockFeignClient.decreaseStock(idProduct, decreaser);
    }

}
