package dev.tcnam.shopcart.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "shopcart")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "iventory")
    private Integer inventory;

    @Column(name = "price")
    private BigDecimal price;

    // @Column(name = "category_id", insertable = false, updatable = false)
    // private Long categoryId;

    @Column(name = "created_timestamp")
	private LocalDateTime createdTimestamp;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "updated_timestamp")
    private LocalDateTime updatedTimestamp;

    @Column(name = "updated_user")
    private String updatedUser;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
    
    @OneToMany()
    @JoinColumn(name = "product_id")
    private List<Image> images;
}
