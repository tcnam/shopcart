package dev.tcnam.shopcart.services.product;

import java.util.List;
import java.util.Optional;

import dev.tcnam.shopcart.dto.response.product.ProductResponseDTO;
import dev.tcnam.shopcart.model.Product;

public interface IProductService {
    
    
    // Optional<Product> getProductById(Long productId);
    List<ProductResponseDTO> searchProducts(String brand, String name, String categoryName);
    // Product addProduct(Product product);
    // void deteteProductById(Long productId);
    // void updateProduct(Product product, Long productId);

    List<ProductResponseDTO> getAllProducts();

}
