package com.example.as24.repositories;

import com.example.as24.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListingRepository extends JpaRepository<Listing, Integer> {

    @Query(value = "SELECT AVG(PRICE) " +
            "FROM ( " +
            "SELECT TOP 30 PERCENT PRICE FROM LISTING, CONTACT  " +
            "WHERE LISTING.ID = LISTING_ID " +
            "GROUP BY LISTING.ID " +
            "ORDER BY COUNT(LISTING_ID) DESC )",
            nativeQuery = true)
    Double getAveragePriceOf30thNtileMostContacted();
}
