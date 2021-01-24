package com.example.as24.entities;

import com.example.as24.dtos.ListingCsvDto;
import com.example.as24.enums.SellerType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "listing")
public class Listing {

    @Id
    private int id;

    private String make;
    private double price;
    private int mileage;

    @Enumerated(EnumType.STRING)
    private SellerType sellerType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listingId")
    private Set<Contact> contacts;

    public Listing(ListingCsvDto listingCsvDto) {
        this.id = listingCsvDto.getId();
        this.make = listingCsvDto.getMake();
        this.price = listingCsvDto.getPrice();
        this.mileage = listingCsvDto.getMileage();
        this.sellerType = SellerType.valueOf(listingCsvDto.getSellerType().toUpperCase());
    }

    public Listing(Listing listing) {
        this.id = listing.getId();
        this.make = listing.getMake();
        this.price = listing.getPrice();
        this.mileage = listing.getMileage();
        this.sellerType = listing.getSellerType();
        this.contacts = listing.getContacts();
    }
}
