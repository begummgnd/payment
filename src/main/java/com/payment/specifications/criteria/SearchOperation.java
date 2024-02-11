package com.payment.specifications.criteria;

import com.payment.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum SearchOperation {
    EQUALS("="),
    NOT_EQUALS("!="),
    GREATER_THAN(">"),
    LESS_THAN("<"),

    GREATER_THAN_EQUAL(">="),
    LESS_THAN_EQUAL("<="),
    CONTAINS("%d%");

    public static SearchOperation getOperation(String operator) {
        return Arrays.stream(SearchOperation.values()).filter(item -> item.operator.equals(operator)).findFirst().orElseThrow(
                () -> {
                    throw new ApiException("hatali", HttpStatus.BAD_REQUEST);
                }
        );
    }

    private String operator;

    SearchOperation(String operator) {
        this.operator = operator;
    }
}
