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
        productService.addProducts(productDtos);
        return productDtos;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getProductDtos();
    }

    @GetMapping("/products/{id}")
    public ProductDto getById(@RequestParam Long id) {
        return productService.getById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/products")
    public void update(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);
    }
}
