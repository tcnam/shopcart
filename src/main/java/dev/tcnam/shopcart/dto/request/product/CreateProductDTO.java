package dev.tcnam.shopcart.dto.request.product;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateProductDTO {
    private String brand;
    private String description;
    private Integer inventory;
    private String name;
    private BigDecimal price;
    private Long categoryId;
}
