package dev.tcnam.shopcart.dto.request.product;

import java.math.BigDecimal;
import java.util.List;

import dev.tcnam.shopcart.dto.request.category.CreateCategoryDTO;
import dev.tcnam.shopcart.dto.request.image.CreateImageDTO;
import lombok.Data;

@Data
public class CreateProductDTO {
    private String name;
    private String brand;
    private String description;
    private Integer inventory;
    private BigDecimal price;
    private CreateCategoryDTO category;
    private List<CreateImageDTO> images;
}
