package com.example.as24.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ContactCsvDto {

    @JsonProperty("listing_id")
    private int listingId;

    @JsonProperty("contact_date")
    private Date contactDate;
}
