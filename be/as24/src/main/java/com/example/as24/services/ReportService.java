package com.example.as24.services;

import com.example.as24.dtos.ContactReportDto;
import com.example.as24.entities.Contact;
import com.example.as24.entities.Listing;
import com.example.as24.enums.SellerType;
import com.example.as24.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class ReportService {

    private final ListingRepository listingRepository;

    @Autowired
    public ReportService(final ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public Map<SellerType, Double> getAveragePricePerSeller() {
        return listingRepository
                .findAll()
                .stream()
                .collect(groupingBy(Listing::getSellerType, averagingDouble(Listing::getPrice)));
    }

    public Map<String, Double> getMakePercentage() {
        List<Listing> listings = listingRepository
                .findAll();
        int totalListings = listings.size();
        return listings
                .stream()
                .collect(
                        groupingBy(Listing::getMake,
                                collectingAndThen(counting(),
                                        count -> 100.00 * count / totalListings
                                )
                        )
                );
    }

    public Double getAveragePriceOf30thNtileMostContacted() {
        return listingRepository.getAveragePriceOf30thNtileMostContacted();
    }

    public Map<String, List<ContactReportDto>> getTop5MostContactedPerMonth() {
        List<Listing> listings = listingRepository.findAll();
        List<String> monthYearList = findDistinctMonthAndYears(listings);
        Map<String, List<ContactReportDto>> monthlyMostContactedListings = new HashMap<>();
        monthYearList.forEach(monthYear ->
                monthlyMostContactedListings.put(monthYear, getTop5Contacted(listings, monthYear))
        );
        return monthlyMostContactedListings;
    }

    private List<String> findDistinctMonthAndYears(List<Listing> listings) {
        return listings
                .stream()
                .flatMap(listing -> listing.getContacts().stream())
                .map(Contact::getMonthAndYear).distinct()
                .collect(toList());
    }

    private List<ContactReportDto> getTop5Contacted(List<Listing> listings, String monthYear) {
        List<Listing> top5Listings = listings.stream()
                .map(listing -> {
                    Listing listingCopy = new Listing(listing);
                    listingCopy.setContacts(listing.getContacts()
                            .stream()
                            .filter(contact -> monthYear.equalsIgnoreCase(contact.getMonthAndYear()))
                            .collect(Collectors.toSet()));
                    return listingCopy;
                })
                .sorted(Comparator.comparing((Listing listing) -> listing.getContacts().size()).reversed())
                .limit(5)
                .collect(Collectors.toList());

        List<ContactReportDto> contactReportDtos = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            contactReportDtos.add(convertToContactReportDto(top5Listings.get(index), index + 1));
        }
        return contactReportDtos;
    }

    private ContactReportDto convertToContactReportDto(Listing listing, int ranking) {
        return ContactReportDto.builder()
                .ranking(ranking)
                .listingId(listing.getId())
                .make(listing.getMake())
                .price(listing.getPrice())
                .mileage(listing.getMileage())
                .totalContacts(listing.getContacts().size())
                .build();
    }
}
