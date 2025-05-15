package dev.tcnam.shopcart.dto.response.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponseDTO {
    private String brand;
    private String description;
    private int inventory;
    private String name;
    private BigDecimal price;
    // private String categoryName;
    // private boolean inStock;
}
