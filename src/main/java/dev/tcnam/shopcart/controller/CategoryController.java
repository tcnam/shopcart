package dev.tcnam.shopcart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.tcnam.shopcart.dto.category.CategoryResponseDTO;
import dev.tcnam.shopcart.services.category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "shopcart/v1/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping()
    public CategoryResponseDTO getCategoryByName(@RequestParam(value = "name") String name) {
        return this.categoryService.getCategoryByName(name);
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id) {
        return this.categoryService.getCategoryById(id);
    }
    
}
