package com.springbootpractices.async;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FindCountriesResponse {
    private final String info = "Check logs to inspect flow";
    private final List<CountryDto> countries;
}
