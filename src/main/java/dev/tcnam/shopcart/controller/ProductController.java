package dev.tcnam.shopcart.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.tcnam.shopcart.dto.product.ProductRequestDTO;
import dev.tcnam.shopcart.dto.product.ProductResponseDTO;
import dev.tcnam.shopcart.model.Product;
import dev.tcnam.shopcart.services.product.IProductService;
import dev.tcnam.shopcart.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "shopcart/v1/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/search")
    public List<ProductResponseDTO> searchProducts(@RequestParam String brand, @RequestParam String name, @RequestParam String categoryName) {
        return this.productService.searchProducts(brand, name, categoryName);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return this.productService.getProductById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        //TODO: process POST request
        try{
            ProductResponseDTO productResponseDTO = this.productService.addProduct(productRequestDTO);
            return ResponseEntity.ok(productResponseDTO);
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    
}