package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.exception.CategoryNotFoundException;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
                .orElseThrow(()-> new CategoryNotFoundException("Category id " +productDto.getCategoryId()+ " not found"));

        Product product = ProductMapper.toProductEntity(productDto,category);
        product =productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }

    public List<ProductDto> getAlllProduct(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDto).toList();
    }

    public ProductDto getProductById(Long id){
         Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
         return ProductMapper.toProductDto(product);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "product"+id+"has been deleted";
    }
}
