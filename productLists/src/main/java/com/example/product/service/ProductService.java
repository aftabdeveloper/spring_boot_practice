package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public ProductDto createProduct(ProductDto productDto){
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));

        Product product = ProductMapper.toProductEntity(productDto,category);
        product =productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }
}
