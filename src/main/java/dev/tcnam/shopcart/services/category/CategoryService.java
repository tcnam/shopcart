package dev.tcnam.shopcart.services.category;

import org.springframework.stereotype.Service;

import dev.tcnam.shopcart.dto.category.CategoryResponseDTO;
import dev.tcnam.shopcart.exeptions.ResourceNotFoundException;
import dev.tcnam.shopcart.mapper.CategoryMapper;
import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO getCategoryByName(String name){
        Category category = this.categoryRepository.findByName(name)
                                                .orElseThrow(()-> new ResourceNotFoundException("Category not found!"));
        return CategoryMapper.toDTO(category);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = this.categoryRepository.findById(id)
                                                .orElseThrow(()-> new ResourceNotFoundException("Category not found!"));
        return CategoryMapper.toDTO(category);
    }
}
