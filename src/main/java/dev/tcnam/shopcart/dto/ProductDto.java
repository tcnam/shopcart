package dev.tcnam.shopcart.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.model.Image;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

// @Data
public class ProductDto {
    private Long productId;
    private String brand;
    private String description;
    private int inventory;
    private String name;
    private BigDecimal price;
    private Long categoryId;
	private LocalDateTime createdTimestamp;
    private String createdUser;
    private LocalDateTime updatedTimestamp;
    private String updatedUser;
    private Category category;
    private List<ImageDto> images;  
}
