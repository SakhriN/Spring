package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductRestController {

    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getOneProduct(@PathVariable int id) {
        Product product = productService.findById(id);
        return product;
    }

    @PostMapping("/addoneproduct")
    public void addOnePerson(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("/edit/{id}")
    public void editProduct(@PathVariable int id, @RequestBody Product product) {
        Product verification = productService.findById(id);
        if (verification != null) {
            product.setId(id);
            productService.save(product);
        }else {
            System.out.println("nique ta soeur");
        }

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
    }

}


