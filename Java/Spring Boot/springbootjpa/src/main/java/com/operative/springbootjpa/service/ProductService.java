package com.operative.springbootjpa.service;

import com.operative.springbootjpa.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     Product addProduct(Product product);

     List<Product> showProducts();

     boolean updateProduct(Long id, Product product);

     boolean deleteProduct(long id);
}
