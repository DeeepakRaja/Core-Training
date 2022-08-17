package com.operative.springbootdemo.entity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    List<Product> products = new ArrayList<Product>();


    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        this.products.add(product);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.products;
    }

    @DeleteMapping("/products/{code}")
    public boolean deleteProduct(@PathVariable("code") int code){
        for (Product p : products){
            if (p.getCode() == code){
                this.products.remove(p);
                return true;
            }
        }
        return false;
    }

    @PutMapping("/products/{code}")
    public Product updateProduct(@PathVariable("code") int code ,@RequestBody Product product){
        products.forEach(prod -> {
            if (prod.getCode()==code)
            {
                prod.setName(product.getName());
                prod.setDesc(product.getDesc());
                prod.setManu(product.getManu());
                prod.setPrice(product.getPrice());
            }
        } );
        return product;
    }

    @GetMapping("/products/{manu}")
    public List<Product> getProductByManufacturer(@PathVariable("manu") String manu){
        List<Product> manuList = new ArrayList<Product>();
        products.forEach(prod -> {
            if (prod.getManu().equalsIgnoreCase(manu)) manuList.add(prod);
        });
        return manuList;
    }
}
