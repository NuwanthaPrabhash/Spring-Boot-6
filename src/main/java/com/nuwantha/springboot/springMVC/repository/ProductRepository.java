package com.nuwantha.springboot.springMVC.repository;

import com.nuwantha.springboot.springMVC.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
