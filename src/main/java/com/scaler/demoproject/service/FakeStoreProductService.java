package com.scaler.demoproject.service;

import com.scaler.demoproject.dto.FakeStoreProductDto;
import com.scaler.demoproject.exceptions.ProductNotFoundException;
import com.scaler.demoproject.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found " +
                    "with id "+ productId);
        }


// You can use the below function to handle 3rd party api responses accordingly
//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.getForEntity(
//                "https://fakestoreapi.com/products/" + productId,
//                FakeStoreProductDto.class
//        );
//
//
//
//        if(fakeStoreProductDto.getStatusCode() == HttpStatus.OK) {
//            // print Hello
//        } else if(fakeStoreProductDto.getStatusCode() == HttpStatus.NOT_FOUND) {
//            // handle things accordingly
//            throw new ProductNotFoundException("Product not found " +
//                    "with id "+ productId);
//        }
//
//        System.out.printf(fakeStoreProductDto.toString());

        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("We are here");
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fs = new FakeStoreProductDto();
        fs.setId(product.getId());
        fs.setTitle(product.getTitle());
        fs.setCategory(product.getCategory().getTitle());
        fs.setImage(product.getImageUrl());
        fs.setDescription(product.getDescription());
        fs.setPrice(product.getPrice());

        FakeStoreProductDto response = restTemplate.postForObject(
              "https://fakestoreapi.com/products",
              fs,
              FakeStoreProductDto.class
        );

//        Product p = new Product();
//        p.setId(response.getId());
//        // set all the variables and return p;
        return response.toProduct();
    }
}
