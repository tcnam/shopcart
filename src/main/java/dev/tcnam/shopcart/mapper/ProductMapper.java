package dev.tcnam.shopcart.mapper;

import org.springframework.stereotype.Component;

import dev.tcnam.shopcart.dto.request.product.CreateProductDTO;
import dev.tcnam.shopcart.model.Product;

@Component
public class ProductMapper {
    public static Product toModel(CreateProductDTO createProductDTO){
        Product prod = new Product();
        prod.setName(createProductDTO.getName());
        prod.setDescription(createProductDTO.getDescription());
        prod.setPrice(createProductDTO.getPrice());
        return prod;
    }
}
