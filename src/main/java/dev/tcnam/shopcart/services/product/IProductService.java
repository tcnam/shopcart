package dev.tcnam.shopcart.services.product;

import java.util.List;
import java.util.Optional;

import dev.tcnam.shopcart.dto.ProductDto;
import dev.tcnam.shopcart.model.Product;

public interface IProductService {
    // Product addProduct(Product product);
    
    Optional<Product> getProductById(Long productId);
    List<Product> searchProducts(String brand, String name, String categoryName);
    // void deteteProductById(Long productId);
    // void updateProduct(Product product, Long productId);

    List<Product> getAllProducts();

    // List<ProductDto> getConvertedProducts(List<Product> products);

    // ProductDto convertToDto(Product product);

}
