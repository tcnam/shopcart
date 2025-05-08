package dev.tcnam.shopcart.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AddProductRequest {
    private String brand;
    private String description;
    private int inventory;
    private String name;
    private BigDecimal price;
    private String categoryName;
}
