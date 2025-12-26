package com.example.coding_challenge.service;

import com.example.coding_challenge.dto.ProductDto;
import com.example.coding_challenge.entity.Product;
import com.example.coding_challenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.getName;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    //List<ProductDto> productDtos = new ArrayList<>();

    public List<ProductDto> getProductDtos() {
        // return products;
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p : products) {
            ProductDto obj = new ProductDto(p.getId(), p.getName(), p.getEmail(), p.getSalary());
            productDtos.add(obj);
        }
        return productDtos;
    }

    public void addProducts(List<ProductDto> productDtos) {
        /*for (ProductDto p : productDtos) {
            products.add(p);
        }*/
        for (ProductDto p : productDtos) {
            Product obj = new Product(p.getName(), p.getSalary(), p.getEmail());
            productRepository.save(obj);
        }
      /*  products.addAll(productDtos);
        return products;*/
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDto getById(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();

            ProductDto obj = new ProductDto(product.getId(), product.getName(), product.getEmail(), product.getSalary());
            return obj;
        }
        return new ProductDto();
    }


    public void updateProduct(ProductDto productDto) {
        Product obj = new Product(productDto.getId(), productDto.getName(), productDto.getSalary(), productDto.getEmail());
        productRepository.save(obj);
    }
}

