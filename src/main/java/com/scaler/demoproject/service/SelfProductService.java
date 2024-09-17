package com.scaler.demoproject.service;

import com.scaler.demoproject.exceptions.ProductNotFoundException;
import com.scaler.demoproject.model.Category;
import com.scaler.demoproject.model.Product;
import com.scaler.demoproject.repositories.CategoryRepository;
import com.scaler.demoproject.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(SelfProductService.class);
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
    public List<Product> getAllProducts(int pageSize, int pageNumber, String fieldName) {
//        Page<Product> allProducts = productRepository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by(fieldName).ascending()));
//        return allProducts;

        return null;
    }

    @Override
    public Product createProduct(Product product) throws ProductNotFoundException{
        // Lets say we are not passing category ID in our request body
        Product respose = new Product();
        try {
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
            }respose = productRepository.save(product);

        } catch (Exception e) {
            // throw some exception
            // this will just print all the exception trace
            e.printStackTrace();
            throw new ProductNotFoundException("Product not found");
//            log.error("Error while creating product" + e.getMessage());
        }
        // Expected exception
        // General catch


        return respose;

    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(product.getId());
        p.get();
        if (!p.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        Product existingInDbProd = p.get();
        if (product.getTitle() != null) {
            existingInDbProd.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            existingInDbProd.setDescription(product.getDescription());
        }
        // Do this for all the fields
        // save the existingInDbProd
        return productRepository.save(existingInDbProd);
    }
}
