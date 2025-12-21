package com.example.coding_challenge.controller;

import com.example.coding_challenge.dto.ProductDto;
import com.example.coding_challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public List<ProductDto> add(@RequestBody List<ProductDto> productDtos) {
        productService.addProduct(productDtos);
        return productDtos;
    }

    @GetMapping("/products")
    public List<ProductDto> product() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDto getById(@RequestParam int id) {
        return productService.getById(id);
    }

    @DeleteMapping("/products/{id}")
    public int deleteById(@PathVariable int id) {
        productService.deleteProduct(id);
        return id;
    }
}
