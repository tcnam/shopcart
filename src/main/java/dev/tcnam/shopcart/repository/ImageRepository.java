package dev.tcnam.shopcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.tcnam.shopcart.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
    List<Image> findByProductId(Long id);
}
