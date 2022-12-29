package com.example.Spring_Security.repository;

import com.example.Spring_Security.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
/*
    List<Product> findByProductName(String productName);
*/

}
