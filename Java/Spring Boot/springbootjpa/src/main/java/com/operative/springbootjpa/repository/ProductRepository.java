package com.operative.springbootjpa.repository;

import com.operative.springbootjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByManufacturer(String manufacturer);
}
