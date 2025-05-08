package dev.tcnam.shopcart.services.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.tcnam.shopcart.dto.ImageDto;
import dev.tcnam.shopcart.dto.ProductDto;
import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.model.Image;
import dev.tcnam.shopcart.model.Product;
import dev.tcnam.shopcart.repository.CategoryRepository;
import dev.tcnam.shopcart.repository.ImageRepository;
import dev.tcnam.shopcart.repository.ProductRepository;
// import dev.tcnam.shopcart.request.AddProductRequest;
import dev.tcnam.shopcart.spec.ProductSpecifications;
import dev.tcnam.shopcart.spec.SearchCriteria;
import dev.tcnam.shopcart.spec.SearchOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;
    // private final ModelMapper modelMapper;

    // @Override
    // public Product addProduct(AddProductRequest request){
    //     Optional<Category> category = this.categoryRepository.findBy
    //     if (category.isPresent() == false){
    //         Category newCategory = new Category(null)
    //     }
    //     return productRepository.save(product);
    // }

    @Override
    public Optional<Product> getProductById(Long productId){
        return productRepository.findById(productId);
    }

    // @Override
    // public void deteteProductById(Long id) {
    //     Optional<Product> prod = this.productRepository.findById(id);
    //     if (prod.isPresent() == true){
    //         this.productRepository.deleteById(id);
    //     }
    // }

    // @Override
    // public void updateProduct(ProductUpdateRequest request, Long productId) {

    // }

    @Override
    public List<Product> searchProducts(String brand, String name, String categoryName){
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

    // @Override
    // public List<ProductDto> getConvertedProducts(List<Product> products) {
    //     return products.stream().map(this::convertToDto).toList();
    // }

    // @Override
    // public ProductDto convertToDto(Product product) {
    //     ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
    //     List<Image> images = this.imageRepository.findByProductId(product.getProductId());
    //     List<ImageDto> imageDtos = images.stream()
    //             .map(image -> modelMapper.map(image, ImageDto.class))
    //             .toList();
    //     productDto.setImages(imageDtos);
    //     return productDto;
    // }

}
