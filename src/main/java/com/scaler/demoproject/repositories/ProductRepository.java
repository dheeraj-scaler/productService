package com.scaler.demoproject.repositories;

import com.scaler.demoproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    // insert into product values ();
    Product findByTitle(String title);
    // select * from product where title = {};
    Product findByDescription(String description);
}

// the attributes that are created by database, you will get it as part
// of the response but you don't have to pass it.

// In order to save something in database
// Insert into product () values ();
