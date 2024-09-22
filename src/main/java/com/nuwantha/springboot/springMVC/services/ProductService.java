package com.nuwantha.springboot.springMVC.services;

import com.nuwantha.springboot.springMVC.models.Product;
import com.nuwantha.springboot.springMVC.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(this.productRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Product> getProductById(Long prodId) {
        Optional<Product> product = this.productRepository.findById(prodId);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new Product(), HttpStatus.NOT_FOUND));
    }

    public Product addProduct(Product product) {
       return this.productRepository.save(product);
    }

    public void updateProduct(Product product) {
        this.productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        this.productRepository.deleteById(productId);
    }
}
