package com.example.Spring_Security.Controller;


import com.example.Spring_Security.Service.ProductService;
import com.example.Spring_Security.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> listProduct(){
        return productService.findAll();
    }
    @PostMapping("/addProduct")
    public Product saveProduct(Product product){
        return productService.saveProduct(product);
    }
    @PutMapping("/update")
    public Product updateProduct(Product product){
        return productService.updateProduct(product);
    }
    @DeleteMapping("/delete")
    public void deleteProduct(Product product){
         productService.deleteProduct(product);
    }
   /* @GetMapping("/find/{name}")
    public List<Product> findByName( @PathVariable(value = "name") String name){
        return (List<Product>) productService.findByProductName(name);
    }*/
    @GetMapping("/finById/{id}")
    public Optional<Product> findById( @PathVariable(value = "id") Long id){
        return productService.findProduct(id);
    }
    /*public Optional<Product> findById( @PathVariable(value = "id") Long id){
        return productService.findProduct(id);
    }*/

}
