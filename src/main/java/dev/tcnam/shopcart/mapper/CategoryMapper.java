package dev.tcnam.shopcart.mapper;

import dev.tcnam.shopcart.dto.request.category.CreateCategoryDTO;
import dev.tcnam.shopcart.dto.request.category.UpdateCategoryDTO;
import dev.tcnam.shopcart.model.Category;

public class CategoryMapper {

    public static Category convertToModel(CreateCategoryDTO createCategoryDTO){
        Category category = new Category();
        category.setName(createCategoryDTO.getName());
        return category;
    }

    public static Category convertToModel(UpdateCategoryDTO updateCategoryDTO){
        Category category = new Category();
        category.setName(updateCategoryDTO.getName());
        return category;
    }
}
