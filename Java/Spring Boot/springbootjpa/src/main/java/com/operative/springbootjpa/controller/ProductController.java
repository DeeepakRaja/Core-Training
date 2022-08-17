package com.operative.springbootjpa.controller;

import com.operative.springbootjpa.entity.Product;
import com.operative.springbootjpa.repository.ProductRepository;
import com.operative.springbootjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository pRepo;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> showProducts(){
        return productService.showProducts();
    }

    @PutMapping("/products/{id}")
    public boolean updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return  productService.updateProduct(id,product);
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/products/manufacturer")
    public ResponseEntity<List<Product>> findByManufacturer(@RequestParam String manufacturer) {
//        return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<List<Product>>(pRepo.findByManufacturer(manufacturer), HttpStatus.OK);
    }
}
