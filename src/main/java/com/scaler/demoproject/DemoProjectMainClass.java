package com.scaler.demoproject;

import com.scaler.demoproject.lldone.Student;
import com.scaler.demoproject.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjectMainClass {

    public static void main(String[] args) {
//        Product p = new Product();
//        p.setTitle("xyz");
//
//        SpringApplication.run(DemoProjectMainClass.class, args);

        Student s1 = new Student();
        s1.name = "Jayaaditya";
        s1.age = 25;

        Student s2 = new Student();
        s2.name = "Kishore";
        s2.age = 24;
        System.out.println("Done with blueprints");
    }

}
