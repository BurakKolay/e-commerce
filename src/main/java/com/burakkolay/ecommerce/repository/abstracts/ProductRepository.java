package com.burakkolay.ecommerce.repository.abstracts;

import com.burakkolay.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    Product getById(int id);
    Product add(Product product);
    Product update(int id, Product product);
    void delete(int id);
}
