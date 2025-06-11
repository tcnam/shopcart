package dev.tcnam.shopcart.services.product;

import java.util.List;

import dev.tcnam.shopcart.dto.product.ProductRequestDTO;
import dev.tcnam.shopcart.dto.product.ProductResponseDTO;

public interface IProductService {
    ProductResponseDTO addProduct(ProductRequestDTO product);
    ProductResponseDTO getProductById(Long productId);
    void deleteProductById(Long productId);
    ProductResponseDTO updateProduct(ProductRequestDTO product, Long productId);
    List<ProductResponseDTO> getAllProducts();
    List<ProductResponseDTO> searchProducts(String brand, String name, String categoryName);
}
