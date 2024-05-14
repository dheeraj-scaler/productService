package com.scaler.demoproject.service;

import com.scaler.demoproject.model.Product;

import java.util.List;

public class DBStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
