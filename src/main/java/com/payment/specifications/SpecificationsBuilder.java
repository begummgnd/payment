package com.payment.specifications;

import com.payment.exception.ApiException;
import com.payment.specifications.criteria.SearchCriteria;
import com.payment.specifications.criteria.SearchOperation;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SpecificationsBuilder<T> {

    private Predicate predicate;

    private Specification<T> createSpecification(SearchCriteria criteria) {

        return (root, query, criteriaBuilder) -> {
            switch (criteria.getOperation()) {

                case EQUALS:
                    predicate = criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());

            }
            return criteriaBuilder.and(predicate);
        };
    }

    public Specification<T> getSpecificationByCriteria(String search) {

        List<SearchCriteria> criteria = new ArrayList<SearchCriteria>();
        try {
            if (StringUtils.isNotBlank(search)) {
                Pattern pattern = Pattern.compile("(\\w+?)(=|<|>|<=|>=|!=|%d%)(\\w+?),");
                Matcher matcher = pattern.matcher(search + ",");
                while (matcher.find()) {
                    criteria.add(new SearchCriteria(matcher.group(1),
                            SearchOperation.getOperation(matcher.group(2)), matcher.group(3)));
                }
            }

            return criteria.stream().map(item -> createSpecification(item)).reduce((spec1, spec2) -> spec1.and(spec2)).orElse(null);

        } catch (Exception e) {
            throw new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

