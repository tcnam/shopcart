package dev.tcnam.shopcart.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


import dev.tcnam.shopcart.dto.request.product.CreateProductDTO;
import dev.tcnam.shopcart.dto.request.product.UpdateProductDTO;
import dev.tcnam.shopcart.dto.response.product.ProductResponseDTO;
import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.model.Product;

public class ProductMapper {

    public static Product convertToModel(CreateProductDTO createProductDTO){
        Product prod = new Product();
        prod.setName(createProductDTO.getName());
        prod.setBrand(createProductDTO.getBrand());
        prod.setDescription(createProductDTO.getDescription());
        prod.setInventory(createProductDTO.getInventory());
        prod.setPrice(createProductDTO.getPrice());

        prod.setCategory(CategoryMapper.convertToModel(createProductDTO.getCategory()));
        return prod;
    }

    public static Product convertToModel(UpdateProductDTO updateProductDTO){
        Product prod = new Product();
        prod.setName(updateProductDTO.getName());
        prod.setBrand(updateProductDTO.getBrand());
        prod.setDescription(updateProductDTO.getDescription());
        prod.setInventory(updateProductDTO.getInventory());
        prod.setPrice(updateProductDTO.getPrice());

        prod.setCategory(CategoryMapper.convertToModel(updateProductDTO.getCategory()));
        return prod;
    }

    public static ProductResponseDTO toResponseDTO(Product product){
        String brand = product.getBrand();
        String description = product.getDescription();
        int inventory = product.getInventory();
        String name = product.getName();
        BigDecimal price = product.getPrice();

        ProductResponseDTO responseDTO = new ProductResponseDTO(brand, description, inventory, name, price);
        
        return responseDTO;
    }
    
    public static List<ProductResponseDTO> toResponseDTOList(List<Product> products) {
        return products.stream()
                        .map(product -> toResponseDTO(product))
                        .collect(Collectors.toList());
    }
}
