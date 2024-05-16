package com.scaler.demoproject;

import com.scaler.demoproject.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjectMainClass {

    public static void main(String[] args) {
        Product p = new Product();
        p.setTitle("xyz");

        SpringApplication.run(DemoProjectMainClass.class, args);
    }

}
