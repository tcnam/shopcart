package dev.tcnam.shopcart.controller;

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

import dev.tcnam.shopcart.model.Product;
import dev.tcnam.shopcart.services.product.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("shopcart/v1/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProducts(@RequestParam String brand, @RequestParam String name, @RequestParam String categoryName) {
        return this.productService.getProducts(brand, name, categoryName);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long productId) {
        return this.productService.getProductById(productId);
    }
    
}