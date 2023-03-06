package com.springbootpractices.async;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryDto {

    private String name;
    private String currency;
    private String capital;

    @Override
    public String toString() {
        return String.format(
                "name: %s, currency: %s, capital: %s",
                name,
                currency,
                capital
        );
    }
}
