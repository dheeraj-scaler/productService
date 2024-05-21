package com.scaler.demoproject.controller;

import com.scaler.demoproject.dto.ErrorDto;
import com.scaler.demoproject.exceptions.ProductNotFoundException;
import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.service.FakeStoreProductService;
import com.scaler.demoproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Product createProduct(@RequestBody Product product) {
       // Whenever someone is doing a post request on /product
       // Plz execute this method
        Product postRequestResponse = productService.createProduct(product);
        return postRequestResponse;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        // Whenever someone is doing a get request on /product/{id}
        // Plz execute this method
        Product currentProduct = productService.getSingleProduct(productId);
        ResponseEntity<Product> res = new ResponseEntity<>(
                currentProduct, HttpStatus.OK);

        //throw new RuntimeException();
        return res;
        //throw new RuntimeException();
        //return currentProduct;
    }

    @GetMapping("/products")
    public void getAllProducts() {
        productService.getAllProducts();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

}
