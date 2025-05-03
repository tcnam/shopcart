package dev.tcnam.shopcart.services.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import dev.tcnam.shopcart.model.Product;
import dev.tcnam.shopcart.repository.ProductRepository;
import dev.tcnam.shopcart.spec.ProductSpecifications;
import dev.tcnam.shopcart.spec.SearchCriteria;
import dev.tcnam.shopcart.spec.SearchOperation;

@Service
public class ProductService implements IProductService{

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long productId){
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> getProducts(String brand, String name, String categoryName){
        List<SearchCriteria> predicates = new ArrayList<>();
        if (!Objects.isNull(brand) || brand != ""){
            SearchCriteria productBrand = new SearchCriteria("brand", SearchOperation.LIKE, brand);
            predicates.add(productBrand);
        }

        if (!Objects.isNull(name) || name != ""){
            SearchCriteria nameBrand = new SearchCriteria("name", SearchOperation.LIKE, name);
            predicates.add(nameBrand);
        }

        ProductSpecifications productSpec = new ProductSpecifications(predicates);

        return productRepository.findAll(productSpec);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
