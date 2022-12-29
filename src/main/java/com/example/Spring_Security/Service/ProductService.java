package com.example.Spring_Security.Service;

import com.example.Spring_Security.domain.Product;
import com.example.Spring_Security.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
         productRepository.delete(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findProduct(Long id) {
        return productRepository.findById(id);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
   /* public List<Product> findByProductName(String name){
        return productRepository.findByProductName(name);
    }*/
}
