package com.example.as24.controllers;

import com.example.as24.entities.Listing;
import com.example.as24.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/rest/listings")
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(final ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping
    public List<Listing> getListings() {
        return listingService.getListings();
    }

    @PostMapping
    public void insertListings(@RequestParam("file") MultipartFile listingsCsv) {
        listingService.insertListings(listingsCsv);
    }

    @PostMapping("/contacts")
    public void insertContacts(@RequestParam("file") MultipartFile contactsCsv) {
        listingService.insertContacts(contactsCsv);
    }

}
