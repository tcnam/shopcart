package dev.tcnam.shopcart.services.product;

import java.util.List;
import java.util.Optional;

import dev.tcnam.shopcart.dto.product.ProductRequestDTO;
import dev.tcnam.shopcart.dto.product.ProductResponseDTO;
import dev.tcnam.shopcart.model.Product;

public interface IProductService {
    
    
    // Optional<ProductResponseDTO> getProductById(Long productId);
    List<ProductResponseDTO> searchProducts(String brand, String name, String categoryName);
    // void addProduct(ProductRequestDTO product);
    // void deteteProductById(Long productId);
    // void updateProduct(ProductRequestDTO product, Long productId);

    List<ProductResponseDTO> getAllProducts();

}
