package com.example.as24.services;

import com.example.as24.dtos.ContactCsvDto;
import com.example.as24.dtos.ListingCsvDto;
import com.example.as24.entities.Contact;
import com.example.as24.entities.Listing;
import com.example.as24.repositories.ContactRepository;
import com.example.as24.repositories.ListingRepository;
import com.example.as24.utilities.CsvUtils;
import com.fasterxml.jackson.databind.MappingIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ListingService {

    private final ListingRepository listingRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public ListingService(final ListingRepository listingRepository,
                          final ContactRepository contactRepository) {
        this.listingRepository = listingRepository;
        this.contactRepository = contactRepository;
    }

    public List<Listing> getListings() {
        return listingRepository.findAll();
    }

    public void insertListings(MultipartFile listingsCsv) {
        MappingIterator<ListingCsvDto> listingCsvDtoMappingIterator = CsvUtils.parseCsv(listingsCsv, ListingCsvDto.class);
        List<Listing> listings = CsvUtils.convertIteratorToList(
                listingCsvDtoMappingIterator,
                (dto) -> new Listing((ListingCsvDto) dto)
        );
        listingRepository.saveAll(listings);
    }

    public void insertContacts(MultipartFile contactsCsv) {
        MappingIterator<ContactCsvDto> contactCsvDtoMappingIterator = CsvUtils.parseCsv(contactsCsv, ContactCsvDto.class);
        List<Contact> contacts = CsvUtils.convertIteratorToList(
                contactCsvDtoMappingIterator,
                (dto) -> new Contact((ContactCsvDto) dto)
        );
        contactRepository.saveAll(contacts);
    }


}

