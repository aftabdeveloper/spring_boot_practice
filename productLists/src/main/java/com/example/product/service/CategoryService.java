package com.example.product.service;

import com.example.product.dto.CategoryDto;
import com.example.product.entity.Category;
import com.example.product.exception.CategoryAlreadyExistsException;
import com.example.product.mapper.CategoryMapper;
import com.example.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto createCategory(CategoryDto categoryDto){

       Optional<Category> optionalCategory = categoryRepository.findByName(categoryDto.getName());
       if(optionalCategory.isPresent()){
           throw new CategoryAlreadyExistsException("category "+ categoryDto.getName()+" already exists");
       }
        Category category = CategoryMapper.toCategoryEntity(categoryDto);
        category = categoryRepository.save(category);
        categoryDto = CategoryMapper.toCategoryDto(category);
        return categoryDto;
    }

    public List<CategoryDto> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDto).toList();
    }

    public CategoryDto getCategoriesById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Categories not found"));
        return CategoryMapper.toCategoryDto(category);
    }

}
