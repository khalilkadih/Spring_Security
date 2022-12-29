package com.example.generatetoken.repository;

import com.example.generatetoken.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
/*
    List<Product> findByProductName(String productName);
*/

}
