package dev.tcnam.shopcart.spec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

import dev.tcnam.shopcart.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import dev.tcnam.shopcart.model.Category;
import dev.tcnam.shopcart.model.Image;


public class ProductSpecifications implements Specification<Product>{

    private List<SearchCriteria> filters;

    public ProductSpecifications (List<SearchCriteria> searchCriterias) {
        this.filters = searchCriterias;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        Join<Product, Category> productJoinCategory = root.join("category", JoinType.INNER);
        Join<Product, Image> productJoinImage = root.join("images", JoinType.INNER);

        if (this.filters.isEmpty() == false) {
            for (SearchCriteria filter : this.filters){
                switch (filter.getOperation()) {
                    case EQUALITY:
                        predicates.add(criteriaBuilder.equal(root.get(filter.getKey()), filter.getValue()));
                        break;
                    case GREATER_THAN:
                        predicates.add(criteriaBuilder.greaterThan(root.get(filter.getKey()), filter.getValue().toString()));
                        break;
                    case LESS_THAN:
                        predicates.add(criteriaBuilder.lessThan(root.get(filter.getKey()), filter.getValue().toString()));
                        break;
                    case LIKE:
                        predicates.add(criteriaBuilder.like(root.get(filter.getKey()), "%"+filter.getValue().toString()+"%"));
                        break;
                    default:
                        break;
                }
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
