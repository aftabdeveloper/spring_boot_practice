package com.example.product.controller;

import com.example.product.dto.CategoryDto;
import com.example.product.exception.CategoryAlreadyExistsException;
import com.example.product.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Category REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE for category REST API"
)
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){

        CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoriesById(@PathVariable Long id){
        return categoryService.getCategoriesById(id);
    }
}
