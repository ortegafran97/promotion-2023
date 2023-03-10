package com.promotion.productsservice.Service.Implementation;

import com.promotion.productsservice.Model.Product;
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

}
