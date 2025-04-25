package dev.tcnam.shopcart.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.tcnam.shopcart.model.Product;
import dev.tcnam.shopcart.repository.ProductRepository;

public class ProductService implements IProductService{

    // @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId){
        return productRepository.findById(productId)
    }

    @Override 
    public void deleteProductById(Long productId){

    }

    @Override
    public void updateProduct(Long productId, Product product){

    }

    @Override
    public List<Product> getAllProducts(){

    }

    @Override
    public List<Product> getProductByCategory(String category) {

    }

    @Override
    public List<Product> getProductByBrand(String brand){

    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand){

    }

    @Override
    public List<Product> getProductsByName(String name){

    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name){

    }

    @Override
    public List<Product> getProductsByCategoryAndName(String category, String name){

    }

    @Override
    public List<Product> getProductsByBrandAndCategoryAndName(String category, String brand, String name){

    }

}
