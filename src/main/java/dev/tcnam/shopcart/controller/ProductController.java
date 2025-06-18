package dev.tcnam.shopcart.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.ACCEPTED;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.tcnam.shopcart.dto.product.ProductRequestDTO;
import dev.tcnam.shopcart.dto.product.ProductResponseDTO;
import dev.tcnam.shopcart.response.ApiResponse;
import dev.tcnam.shopcart.services.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "shopcart/v1/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchProducts(@RequestParam String brand, @RequestParam String name, @RequestParam String categoryName) {
        try {
            List<ProductResponseDTO> listProductResponseDTO = this.productService.getAllProducts();
            return ResponseEntity.status(OK).body(new ApiResponse("Product found", listProductResponseDTO));
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id) {
        try {
            ProductResponseDTO productResponseDTO = this.productService.getProductById(id);
            return ResponseEntity.status(OK).body(new ApiResponse("Product found", productResponseDTO));
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        //TODO: process POST request
        try{
            ProductResponseDTO productResponseDTO = this.productService.addProduct(productRequestDTO);
            return ResponseEntity.status(OK).body(new ApiResponse("Add product success", productResponseDTO));
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateProductById(@RequestBody ProductRequestDTO productRequestDTO, @RequestParam Long productId) {
        //TODO: process POST request
        try{
            ProductResponseDTO productResponseDTO = this.productService.updateProduct(productRequestDTO, productId);
            return ResponseEntity.status(OK).body(new ApiResponse("Update product success", productResponseDTO));
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable Long id){
        try{
            this.productService.deleteProductById(id);
            return ResponseEntity.status(ACCEPTED).body(new ApiResponse("Delete product success", id));

        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Cannot find product", id));
        }
    }
    
}