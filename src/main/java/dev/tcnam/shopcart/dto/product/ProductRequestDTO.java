package dev.tcnam.shopcart.dto.product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import dev.tcnam.shopcart.model.Image;
import dev.tcnam.shopcart.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDTO {
    private final String name;
    private final String brand;
    private final String description;
    private final int inventory;
    private final BigDecimal price;
    private final Category category;
    private final List<Image> images;
}
