package com.springbootpractices.specification.controller.param;

import com.springbootpractices.specification.config.SearchOperation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;
}
