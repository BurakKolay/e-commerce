package com.burakkolay.ecommerce.repository.concretes;

import com.burakkolay.ecommerce.entities.concretes.Product;
import com.burakkolay.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> products;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(1,"Iphone 14",10,20000,"apple's product"));
        products.add(new Product(2,"PS5",5,17000,"apple's product"));
        products.add(new Product(3,"XBOX",10,20000,"apple's product"));
        products.add(new Product(4,"Ipad Mini",10,12000,"apple's product"));
        products.add(new Product(5,"Dyson v15",10,14999.99,"apple's product"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if(product.getId() == id) return product;
        }
        return null;
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        return products.set(id-1,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id-1);
    }
}
