package com.operative.springbootjpa.service;

import com.operative.springbootjpa.entity.Product;
import com.operative.springbootjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> showProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            Product prodTemp = productRepository.findById(id).get();
            prodTemp.setName(product.getName());
            prodTemp.setDescription(product.getManufacturer());
            prodTemp.setManufacturer(product.getManufacturer());
            prodTemp.setPrice(product.getPrice());

            productRepository.save(prodTemp);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(long id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

