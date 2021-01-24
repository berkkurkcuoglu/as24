package com.example.as24.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContactReportDto {

    private int ranking;
    private int listingId;
    private String make;
    private double price;
    private double mileage;
    private int totalContacts;

}
