package dev.tcnam.shopcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dev.tcnam.shopcart.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    Optional<Category> findByName(String name);
    boolean existsByName(String name);
}
