package com.scaler.demoproject.service;

import com.scaler.demoproject.exceptions.ProductNotFoundException;
import com.scaler.demoproject.model.Category;
import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.repositories.CategoryRepository;
import com.scaler.demoproject.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(productId);
        if(p.isPresent()) {
            return p.get();
        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        // Lets say we are not passing category ID in our request body
        Category cat = categoryRepository.findByTitle(product.getCategory().getTitle());
        if(cat == null) {
            // No category with our title in the database
            Category newCat = new Category();
            newCat.setTitle(product.getCategory().getTitle());
            Category newRow = categoryRepository.save(newCat);
            // newRow will have now catId
            product.setCategory(newRow);
        } else {
            product.setCategory(cat);
        }

        Product savedProduct = productRepository.save(product);
        return savedProduct;

    }
}
