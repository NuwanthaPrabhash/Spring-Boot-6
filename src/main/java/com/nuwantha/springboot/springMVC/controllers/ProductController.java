package com.nuwantha.springboot.springMVC.controllers;

import com.nuwantha.springboot.springMVC.models.Product;
import com.nuwantha.springboot.springMVC.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // To remove cross-origin error firing in front end
@RequestMapping(value = "products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * return all the products
     * @return list of product and status of the response
     */
    @GetMapping(value = "/getProducts")
    public ResponseEntity<List<Product>> getProduct() {
        return productService.getProducts();
    }

    @GetMapping(value = "/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long prodId) {
        return this.productService.getProductById(prodId);
    }

    @PostMapping(value = "/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    @PutMapping(value = "/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        this.productService.updateProduct(product);
    }

    @DeleteMapping(value = "{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        this.productService.deleteProduct(productId);
    }
}
