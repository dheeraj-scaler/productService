package com.scaler.demoproject.service;

import com.scaler.demoproject.exceptions.ProductNotFoundException;
import com.scaler.demoproject.model.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product) throws ProductNotFoundException;
    Product updateProduct(Product product) throws ProductNotFoundException;
}
