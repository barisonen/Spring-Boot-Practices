package com.springbootpractices.async;

import lombok.Data;

import java.util.List;

@Data
public class FindCountriesRequest {
    private List<String> countryCodes;
}
