package com.example.product.mapper;

import com.example.product.dto.CategoryDto;
import com.example.product.entity.Category;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDto toCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setProducts(category.getProducts().stream().map(ProductMapper::toProductDto).collect(Collectors.toList()));
        return categoryDto;
    }

    public static Category toCategoryEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }
}
