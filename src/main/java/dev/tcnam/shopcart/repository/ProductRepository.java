package dev.tcnam.shopcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.tcnam.shopcart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
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
