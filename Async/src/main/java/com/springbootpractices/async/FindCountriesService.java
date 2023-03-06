package com.springbootpractices.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Log4j2
@RequiredArgsConstructor
public class FindCountriesService {

    private final CountryLookupService countryLookupService;

    public List<CountryDto> findCountriesService(List<String> countryCodes) {
        List<CompletableFuture<CountryDto>> countries = new ArrayList<>();
        countryCodes.forEach(countryCode -> {
            try {
                countries.add(countryLookupService.findCountryByCountryCode(countryCode));
            } catch (InterruptedException e) {
                log.error("Error occurred, skipping " + countryCode);
            }
        });

        CompletableFuture.allOf(countries.toArray(CompletableFuture[]::new)).join();

        List<CountryDto> result = new ArrayList<>();

        countries.forEach(countryDtoCompletableFuture -> {
            try {
                CountryDto countryDto = countryDtoCompletableFuture.get();
                log.info(countryDto);
                result.add(countryDto);
            } catch (InterruptedException | ExecutionException e) {
                log.error("Error occurred");
            }
        });

        return result;
    }
}
