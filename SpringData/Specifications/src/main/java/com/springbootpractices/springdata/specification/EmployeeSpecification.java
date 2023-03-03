package com.springbootpractices.springdata.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeSpecification implements Specification<Employee> {

    private final List<SearchCriteria> list = new ArrayList<>();

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : list) {
            switch (criteria.getOperation()) {
                case GREATER_THAN ->
                        predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                case LESS_THAN ->
                        predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
                case GREATER_THAN_EQUAL ->
                        predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
                case LESS_THAN_EQUAL ->
                        predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
                case NOT_EQUAL ->
                        predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
                case EQUAL ->
                        predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
                case LIKE ->
                        predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
                case LIKE_END ->
                        predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%"));
                case LIKE_START ->
                        predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase()));
                case IN ->
                        predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
                case NOT_IN ->
                        predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
