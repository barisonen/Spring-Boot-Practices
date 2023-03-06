package com.springbootpractices.async;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Country {

    @JsonProperty("name")
    private JsonNode name;

    @JsonProperty("currencies")
    private JsonNode currencies;

    @JsonProperty("capital")
    private JsonNode capital;
}
