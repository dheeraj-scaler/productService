package com.scaler.demoproject;

import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoProjectMainClassTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }
    
    @Test
    void testingQueries() {
        List<Product> products = productRepository.findAll();
    }

}
