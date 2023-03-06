package com.springbootpractices.async;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;

@Log4j2
@Service
public class CountryLookupService {

    private final RestTemplate restTemplate;

    public CountryLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<CountryDto> findCountryByCountryCode(String countryCode) throws InterruptedException {
        log.info("Looking up " + countryCode);
        String url = String.format("https://restcountries.com/v3.1/alpha/%s?fields=name,capital,currencies",
                countryCode);

        Country result = restTemplate.getForObject(url, Country.class);

        if(result != null) {
            String name = result.getName().get("official").asText();
            String currency = result.getCurrencies().fields().next().getKey();
            String capital = result.getCapital().get(0).asText();

            CountryDto countryDto = CountryDto.builder()
                    .name(name)
                    .currency(currency)
                    .capital(capital)
                    .build();

            return CompletableFuture.completedFuture(countryDto);
        }

        return null;
    }

}
