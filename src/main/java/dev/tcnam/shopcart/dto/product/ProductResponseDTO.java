package dev.tcnam.shopcart.dto.product;

import java.math.BigDecimal;
import java.util.List;
import dev.tcnam.shopcart.dto.category.CategoryResponseDTO;
import dev.tcnam.shopcart.dto.image.ImageResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductResponseDTO {
    private final Long productId;
    private final String name;
    private final String brand;
    private final String description;
    private final int inventory;
    private final BigDecimal price;
    private final CategoryResponseDTO category;
    private final List<ImageResponseDTO> images;
}
