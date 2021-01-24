package com.example.as24.entities;

import com.example.as24.dtos.ContactCsvDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

@NoArgsConstructor
@Data
@Entity
@Table(name = "contact")
public class Contact {

    @GeneratedValue
    @Id
    private int id;

    @JsonIgnore
    private int listingId;

    private Date contactDate;

    public Contact(ContactCsvDto contactCsvDto) {
        this.listingId = contactCsvDto.getListingId();
        this.contactDate = contactCsvDto.getContactDate();
    }

    public String getMonthAndYear() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.getContactDate());
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH) + 1;
        return new StringJoiner(".")
                .add(month.toString())
                .add(year.toString())
                .toString();
    }
}
