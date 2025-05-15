package dev.tcnam.shopcart.dto.request.product;

import java.math.BigDecimal;
import java.util.List;

import dev.tcnam.shopcart.dto.request.category.UpdateCategoryDTO;
import dev.tcnam.shopcart.dto.request.image.UpdateImageDTO;
import lombok.Data;

@Data
public class UpdateProductDTO {
    private String name;
    private String brand;
    private String description;
    private Integer inventory;
    private BigDecimal price;
    private UpdateCategoryDTO category;
    private List<UpdateImageDTO> images;
}
