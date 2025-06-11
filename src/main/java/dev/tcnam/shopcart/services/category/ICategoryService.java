package dev.tcnam.shopcart.services.category;

import dev.tcnam.shopcart.dto.category.CategoryResponseDTO;

public interface ICategoryService {
    CategoryResponseDTO getCategoryByName(String name);
    CategoryResponseDTO getCategoryById(Long id);
}
