package com.burakkolay.ecommerce.api.controllers;

import com.burakkolay.ecommerce.business.abstracts.ProductService;
import com.burakkolay.ecommerce.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id,@RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
}
