package com.example.product.controller;

import com.example.product.dto.CategoryDto;
import com.example.product.dto.ProductDto;
import com.example.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Product REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE for product REST API"
)
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto),HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAlllProduct();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id,productDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }


}

