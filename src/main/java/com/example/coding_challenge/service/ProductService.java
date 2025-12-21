package com.example.coding_challenge.service;

import com.example.coding_challenge.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<ProductDto> products = new ArrayList<>();

    public List<ProductDto> getProducts() {
        return products;
    }

    public List<ProductDto> addProduct(List<ProductDto> productDtos) {
        /*for (ProductDto p : productDtos) {
            products.add(p);
        }*/
        products.addAll(productDtos);
        return products;
    }


    public void deleteProduct(int id) {
        for (ProductDto p : products) {
            if (p.getId() == id) {
                products.remove(p);
            }
        }
    }

    public ProductDto getById(int id) {
        for (ProductDto p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return new ProductDto();
    }
}

