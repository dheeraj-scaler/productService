package com.scaler.demoproject.controller;

import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    @Test
    void createProduct() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void getAllProducts() {
        // Call the method in product controller and get a list of products
        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("First product");
        p1.setPrice(1);

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("Second product");
        p2.setPrice(2);

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("Third product");
        p3.setPrice(3);

        List<Product> mockList = new ArrayList<>();
        mockList.add(p1);
        mockList.add(p2);
        mockList.add(p3);


        // This is product service mocking
        when(productService.getAllProducts(0,0,"xyz"))
                .thenReturn(mockList);

        // This is calling the actual product controller get all product function
        List<Product> actualRes = productController.getAllProducts(0,0,"xyz");

        assertEquals(actualRes.size(),3 );
        assertEquals(actualRes, mockList);

        // controller -> service
        // controller(0,0,xyz) -> service (0,0,xyz) (return with the mockList)
    }

    @Test
    void checkHealthOfTheService() {
    }

    @Test
    void updateProduct() {
    }
}