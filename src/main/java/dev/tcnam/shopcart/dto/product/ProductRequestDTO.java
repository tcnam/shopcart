package dev.tcnam.shopcart.dto.product;

import java.math.BigDecimal;
import java.util.Set;

import dev.tcnam.shopcart.dto.category.CategoryRequestDTO;
import dev.tcnam.shopcart.dto.image.ImageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductRequestDTO {
    private final String name;
    private final String brand;
    private final String description;
    private final int inventory;
    private final BigDecimal price;
    private final CategoryRequestDTO category;
    private final Set<ImageRequestDTO> images;
}
