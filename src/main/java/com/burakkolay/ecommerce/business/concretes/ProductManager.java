package com.burakkolay.ecommerce.business.concretes;

import com.burakkolay.ecommerce.business.abstracts.ProductService;
import com.burakkolay.ecommerce.entities.Product;
import com.burakkolay.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
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
