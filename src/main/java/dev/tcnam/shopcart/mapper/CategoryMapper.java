package dev.tcnam.shopcart.mapper;

import dev.tcnam.shopcart.dto.category.CategoryRequestDTO;
import dev.tcnam.shopcart.dto.category.CategoryResponseDTO;
import dev.tcnam.shopcart.model.Category;

public class CategoryMapper {

    public static Category toModel(CategoryRequestDTO categoryRequestDTO){
        Category category = new Category();
        category.setName(categoryRequestDTO.getName());
        return category;
    }

    public static CategoryResponseDTO toDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(category.getCategoryId(), category.getName());
        return categoryResponseDTO;
    }
}
