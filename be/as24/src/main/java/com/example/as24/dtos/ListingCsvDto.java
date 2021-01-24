package com.example.as24.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListingCsvDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("make")
    private String make;

    @JsonProperty("price")
    private double price;

    @JsonProperty("mileage")
    private int mileage;

    @JsonProperty("seller_type")
    private String sellerType;

}
