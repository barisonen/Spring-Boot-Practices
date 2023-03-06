package com.springbootpractices.async;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FindCountriesController {

    private final FindCountriesService findCountriesService;

    @PostMapping("/get-countries-by-code-list")
    public FindCountriesResponse getCountriesByCodeList(@RequestBody FindCountriesRequest request) {
        List<CountryDto> countries = findCountriesService.findCountriesService(request.getCountryCodes());
        return FindCountriesResponse.builder()
                .countries(countries)
                .build();
    }
}
