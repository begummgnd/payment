package com.payment.specifications.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria implements Serializable {

    private String key;
    private SearchOperation operation;
    private Object value;
}
