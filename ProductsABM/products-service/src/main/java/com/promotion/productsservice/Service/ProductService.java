package com.promotion.productsservice.Service;

import com.promotion.productsservice.Model.Product;
import com.promotion.productsservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID idProduct){
        return productRepository.findById(idProduct);
    }

    public Product saveOne(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> updateOne(Product product){
        Optional<Product> updatable  = findById(product.getId());

        if(updatable.isEmpty())
            return Optional.empty();

        return Optional.of(productRepository.save(product));
    }

    public Boolean deleteOne(UUID idProduct){
        productRepository.deleteById(idProduct);
        return findById(idProduct).isEmpty();
    }

}
