package com.promotion.productsservice.Controller;

import com.promotion.productsservice.Exceptions.Classes.AlreadyExistsException;
import com.promotion.productsservice.Exceptions.Classes.CouldntCompleteException;
import com.promotion.productsservice.Exceptions.Classes.NotFoundException;
import com.promotion.productsservice.Model.Category;
import com.promotion.productsservice.Model.Product;
import com.promotion.productsservice.Model.Stock;
import com.promotion.productsservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") UUID idProduct){
        Optional<Product> product = productService.findById(idProduct);

        if(product.isEmpty())
            throw new NotFoundException("Producto no encontrado.");

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> saveOne(@RequestBody Product product){
        if(product.getId() != null && productService.findById(product.getId()).isPresent())
            throw new AlreadyExistsException("El producto ya existe.");

        return ResponseEntity.ok(productService.saveOne(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOne(@PathVariable("id") UUID idProduct){
        if(!productService.deleteOne(idProduct))
            throw new CouldntCompleteException("No se elimino el producto.");

        return ResponseEntity.ok(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Product>> updateOne(@PathVariable("id") UUID id, @RequestBody Product product){
        product.setId(id);
        Optional<Product> updated = productService.updateOne(product);

        if(updated.isEmpty())
            throw new CouldntCompleteException("No se actualizo el producto.");


        return ResponseEntity.ok(updated);
    }

    /* Microservices communication */

    /* Category */
    @GetMapping("/{idProduct}/category")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable("idProduct")UUID idProduct){
        Optional<Category> category = productService.findProductCategory(idProduct);

        if(category.isEmpty())
            throw new NotFoundException("Categoría no encontrada.");

        return ResponseEntity.ok(category);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategories(){
        return ResponseEntity.ok(productService.findAllCategories());
    }


    /* Stock */
    @GetMapping("/{idProduct}/stock")
    public ResponseEntity<Optional<Stock>> getStockForProduct(@PathVariable("idProduct") UUID idProduct){
        return ResponseEntity.ok(productService.findProductStock(idProduct));
    }

}
