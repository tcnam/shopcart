package dev.tcnam.shopcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category>{
    // List<Image> findByProductId(Long id);
}
