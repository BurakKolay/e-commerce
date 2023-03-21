package com.burakkolay.ecommerce.business.concretes;

import com.burakkolay.ecommerce.business.abstracts.ProductService;
import com.burakkolay.ecommerce.entities.concretes.Product;
import com.burakkolay.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    @Autowired
    private ProductRepository repository;


    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Product add(Product product) {

        return repository.add(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return repository.update(id,product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
    private void validateProduct(Product product){
        checkIfPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionValid(product);
    }
    private void checkIfPriceValid(Product product){
        if(product.getPrice()<=0) throw new IllegalArgumentException("Price cannot be less than or equal to zero");
    }
    private void checkIfQuantityValid(Product product){
        if(product.getQuantity()<0) throw new IllegalArgumentException("Quantity cannot be less than zero");
    }
    private void checkIfDescriptionValid(Product product){
        if(product.getDescription().length()<10||product.getDescription().length()>50) throw new IllegalArgumentException("Description length cannot be less than 10" +
                "and more than 50 length");
    }
}
