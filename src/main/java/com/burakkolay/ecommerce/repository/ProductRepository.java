package com.burakkolay.ecommerce.repository;

import com.burakkolay.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {
}
