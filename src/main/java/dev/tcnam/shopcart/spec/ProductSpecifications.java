package dev.tcnam.shopcart.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

import dev.tcnam.shopcart.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import dev.tcnam.shopcart.model.Category;

public class ProductSpecifications implements Specification<Product>{

    public static Specification<Product> brandLike(String brand){
        return (root, query, criteriaBuilder) ->{
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("brand")), "%"+brand.toLowerCase()+"%");
        };
            
    }

    public static Specification<Product> nameLike(String name){
        return (root, query, criteriaBuilder) ->{
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%"+name.toLowerCase()+"%");
        };
    }

    public static Specification<Product> categoryLike(String category){
        return (root, query, criteriaBuilder) -> {
            Join<Product, Category> categoryJoin = root.join()
        }
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        // TODO Auto-generated method stub
        List<Predicate> predicates = new ArrayList<>();
        Root<Product> productRoot = query.from(Product.class);
        Join<Product, Category> categoryJoin = root.join(null, null))

        throw new UnsupportedOperationException("Unimplemented method 'toPredicate'");
    }
}
