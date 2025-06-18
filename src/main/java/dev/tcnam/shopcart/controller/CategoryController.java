package dev.tcnam.shopcart.controller;

import java.util.List;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.ACCEPTED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.tcnam.shopcart.dto.category.CategoryResponseDTO;
import dev.tcnam.shopcart.response.ApiResponse;
import dev.tcnam.shopcart.services.category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@RestController
@RequestMapping(value = "shopcart/v1/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<ApiResponse> getCategoryByName(@RequestParam(value = "name") String name) {
        try {
            CategoryResponseDTO categoryResponseDTO = this.categoryService.getCategoryByName(name);
            return ResponseEntity.status(OK).body(new ApiResponse("Category found", categoryResponseDTO));
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id) {
        return this.categoryService.getCategoryById(id);
    }

    // @PostMapping("/")
    // public String postMethodName(@RequestBody String entity) {
    //     //TODO: process POST request
        
    //     return entity;
    // }
    
    
}
