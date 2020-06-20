package com.sumer.labs.productservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sumer.labs.commons.dto.CategoryDto;
import com.sumer.labs.productservice.service.CategoryService;

import java.util.List;

import static com.sumer.labs.commons.utils.web.Web.API;

@RestController
@RequestMapping(API + "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll(){
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id){
        return this.categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto create(CategoryDto categoryDto){
        return this.categoryService.create(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.categoryService.delete(id);
    }

}
