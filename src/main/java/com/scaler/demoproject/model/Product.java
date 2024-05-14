package com.scaler.demoproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    public String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
