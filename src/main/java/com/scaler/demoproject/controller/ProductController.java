package com.scaler.demoproject.controller;

import com.scaler.demoproject.service.FakeStoreProductService;
import com.scaler.demoproject.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class ProductController {

// POST /product
//    Request Body
//    {
//        "title": "Apple airpods",
//            "price": 25000,
//            "description": "Best airpods ever",
//            "image": "https://i.pravatar.cc",
//            "category": "electronic"
//    }

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void createProduct() {
//        productService.createProduct();
       // Whenever someone is doing a post request on /product
       // Plz execute this method
    }

    @GetMapping("/products/{id}")
    public void getProduct(@PathVariable("id") Long productId) {
        // Whenever someone is doing a get request on /product/{id}
        // Plz execute this method
    }

    @GetMapping("/products")
    public void getAllProducts() {
        productService.getAllProducts();
    }

}
