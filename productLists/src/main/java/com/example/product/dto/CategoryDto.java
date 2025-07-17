package com.example.product.dto;

import lombok.*;

import java.util.List;

public class CategoryDto {
    private Long id;
    private String name;
    private List<ProductDto> products;

    public CategoryDto() {
    }

    // --- All-arg constructor ---
    public CategoryDto(Long id, String name, List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    // --- Setters ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
