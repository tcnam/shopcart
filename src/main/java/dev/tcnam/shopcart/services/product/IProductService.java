package dev.tcnam.shopcart.services.product;

import java.util.List;
import java.util.Optional;

import dev.tcnam.shopcart.model.Product;

public interface IProductService {
    Product addProduct(Product product);
    
    Optional<Product> getProductById(Long productId);
    List<Product> getProducts(String brand, String name, String categoryName);
    // void deteteProductById(Long productId);
    // void updateProduct(Long productId, Product product);

    List<Product> getAllProducts();
    // List<Product> getProductByCategory(String category);
    // List<Product> getProductByBrand(String brand);
    // List<Product> getProductsByCategoryAndBrand(String category, String brand);
    // List<Product> getProductsByName(String name);
    // List<Product> getProductsByBrandAndName(String brand, String name);
    // List<Product> getProductsByCategoryAndName(String category, String name);
    // List<Product> getProductsByBrandAndCategoryAndName(String category, String brand, String name);

}
