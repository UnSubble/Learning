package com.unsubble.lesson3._01.service;

import com.unsubble.lesson3._01.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    void addProduct(Product product);
}
