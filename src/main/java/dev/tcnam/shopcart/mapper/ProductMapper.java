package dev.tcnam.shopcart.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.tcnam.shopcart.dto.request.product.CreateProductDTO;
import dev.tcnam.shopcart.dto.response.product.ProductResponseDTO;
import dev.tcnam.shopcart.model.Product;

@Component
public class ProductMapper {

    public Product toModel(CreateProductDTO createProductDTO){
        Product prod = new Product();
        prod.setName(createProductDTO.getName());
        prod.setDescription(createProductDTO.getDescription());
        prod.setPrice(createProductDTO.getPrice());
        prod.setCategoryId(createProductDTO.getCategoryId());
        return prod;
    }

    public ProductResponseDTO toResponseDTO(Product product){
        String brand = product.getBrand();
        String description = product.getDescription();
        int inventory = product.getInventory();
        String name = product.getName();
        BigDecimal price = product.getPrice();

        ProductResponseDTO responseDTO = new ProductResponseDTO(brand, description, inventory, name, price);
        
        return responseDTO;
    }
    
    public List<ProductResponseDTO> toResponseDTOList(List<Product> products) {
        return products.stream()
                        .map(product -> toResponseDTO(product))
                        .collect(Collectors.toList());
    }
}
