package dev.tcnam.shopcart.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryResponseDTO {
    private Long categoryId;
    private String name;
}
