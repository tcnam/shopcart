package dev.tcnam.shopcart.services.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import dev.tcnam.shopcart.dto.product.ProductRequestDTO;
import dev.tcnam.shopcart.dto.product.ProductResponseDTO;
import dev.tcnam.shopcart.exeptions.ResourceNotFoundException;
import dev.tcnam.shopcart.mapper.ProductMapper;
import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.model.Product;
import dev.tcnam.shopcart.repository.CategoryRepository;
// import dev.tcnam.shopcart.repository.ImageRepository;
import dev.tcnam.shopcart.repository.ProductRepository;
import dev.tcnam.shopcart.spec.ProductSpecifications;
import dev.tcnam.shopcart.spec.SearchCriteria;
import dev.tcnam.shopcart.spec.SearchOperation;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;
    // private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;

    // @Autowired
    // public ProductService(ProductRepository productRepository, ImageRepository imageRepository, CategoryRepository categoryRepository){
    //     this.productRepository = productRepository;
    //     this.imageRepository = imageRepository;
    //     this.categoryRepository = categoryRepository;
    // }
    private Product createProduct(ProductRequestDTO request){
        Product product = new Product();
        product.setName(request.getName());
        product.setBrand(request.getBrand());
        product.setDescription(request.getDescription());
        product.setInventory(request.getInventory());
        product.setPrice(request.getPrice());
        product.setCreatedTimestamp(LocalDateTime.now());
        product.setCreatedUser("Admin");
        product.setUpdatedTimestamp(LocalDateTime.now());
        product.setUpdatedUser("Admin");
        product.setCategory(request.getCategory());
        product.setImages(request.getImages());
        return product;
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO request){
        // check if the category is found in the DB
        // If Yes, set it as the new product category
        // If No, the save it as a new category
        // The set as the new product category.
        Category category = this.categoryRepository.findByName(request.getCategory().getName())
                                                    .orElseGet(()->{
                                                        Category newCategory = new Category(request.getCategory().getName());
                                                        return this.categoryRepository.save(newCategory);
                                                    });

        Product product = this.createProduct(request);
        // product.getImages().stream().map()
        product.setCategory(category);
        return ProductMapper.toDTO(this.productRepository.save(product));
                    
    }

    @Override
    public void deleteProductById(Long productId) {
        this.productRepository.findById(productId)
                .ifPresentOrElse(
                    this.productRepository::delete,
                    () -> {throw new ResourceNotFoundException("Product not found!");}
                );
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO request, Long productId) {
        return ProductMapper.toDTO(
            this.productRepository.findById(productId)
                .map(existingProduct -> updateExistingProduct(existingProduct,request))
                .map(productRepository :: save)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found!"))
        );
    }

    private Product updateExistingProduct(Product existingProduct, ProductRequestDTO request) {
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescription(request.getDescription());

        Category category = this.categoryRepository.findByName(request.getCategory().getName())
                                                    .orElseGet(()->{
                                                        Category newCategory = new Category(request.getCategory().getName());
                                                        return this.categoryRepository.save(newCategory);
                                                    });
        existingProduct.setCategory(category);
        return  existingProduct;

    }

    @Override
    public ProductResponseDTO getProductById(Long productId){
        Product product = this.productRepository.findById(productId)
                                                .orElseThrow(()-> new ResourceNotFoundException("Product not found!"));
        return ProductMapper.toDTO(product);
        
    }


    @Override
    public List<ProductResponseDTO> searchProducts(String brand, String name, String categoryName){
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

        List<Product> products = new ArrayList<Product>();
        products = this.productRepository.findAll(productSpec);
        return ProductMapper.toDTOList(products);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        products = this.productRepository.findAll();
        return ProductMapper.toDTOList(products);
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
