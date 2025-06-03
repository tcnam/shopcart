package dev.tcnam.shopcart.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.tcnam.shopcart.dto.category.CategoryRequestDTO;
import dev.tcnam.shopcart.dto.image.ImageRequestDTO;
import dev.tcnam.shopcart.dto.product.ProductRequestDTO;
import dev.tcnam.shopcart.dto.product.ProductResponseDTO;
import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.model.Image;
import dev.tcnam.shopcart.model.Product;

public class ProductMapper {

    public static Product toModel(ProductRequestDTO productRequestDTO){
        Product prod = new Product();

        prod.setName(productRequestDTO.getName());
        prod.setBrand(productRequestDTO.getBrand());
        prod.setDescription(productRequestDTO.getDescription());
        prod.setInventory(productRequestDTO.getInventory());
        prod.setPrice(productRequestDTO.getPrice());

        prod.setCategory(CategoryMapper.toModel(productRequestDTO.getCategory()));
        // prod.setImages(ImageMapper.toModel(productRequestDTO.getImages()));
        return prod;
    }

    public static ProductResponseDTO toDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO(
            product.getProductId(),
            product.getName(),
            product.getBrand(),
            product.getDescription(),
            product.getInventory(),
            product.getPrice(),
            CategoryMapper.toDTO(product.getCategory()),
            ImageMapper.toDTOList(product.getImages())
        );
        return responseDTO;
    }
    
    public static List<ProductResponseDTO> toDTOList(List<Product> products) {
        return products.stream()
                        .map(product -> toDTO(product))
                        .collect(Collectors.toList());
    }
}
